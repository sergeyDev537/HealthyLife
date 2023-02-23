package com.exlab.healthylife.data.impl

import com.exlab.healthylife.app.base.network.BaseRetrofitSource
import com.exlab.healthylife.app.base.network.RetrofitConfig
import com.exlab.healthylife.app.settings.AppSettings
import com.exlab.healthylife.data.UserField
import com.exlab.healthylife.data.mappers.AccountMapper
import com.exlab.healthylife.data.network.api.AccountsApi
import com.exlab.healthylife.data.network.models.AccountDto
import com.exlab.healthylife.domain.entities.AccountEntity
import com.exlab.healthylife.domain.repositories.AccountsSource
import com.exlab.healthylife.utils.*
import com.exlab.healthylife.utils.async.LazyFlowSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountsSourceImpl @Inject constructor(
    config: RetrofitConfig,
    private val accountsApi: AccountsApi,
    private val accountMapper: AccountMapper,
    private val appSettings: AppSettings
): BaseRetrofitSource(config), AccountsSource {

    private val accountEntityLazyFlowSubject = LazyFlowSubject<Unit, AccountEntity> {
        doGetAccount()
    }

    fun isSignedIn(): Boolean {
        return appSettings.getCurrentUserToken() != null
    }

    override suspend fun signIn(email: String, password: String) {
        if (email.isBlank()) throw EmptyFieldException(UserField.Email)
        if (password.isBlank()) throw EmptyFieldException(UserField.Password)

        try {
            val signInRequest = AccountDto(email, password)
            accountsApi.signIn(signInRequest)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 400) {
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        appSettings.setCurrentUserToken(email)
        accountEntityLazyFlowSubject.updateAllValues(getAccount())
    }

    override suspend fun signUp(
        accountEntity: AccountEntity
    ) = wrapRetrofitExceptions {
        try {
            accountsApi.signUp(accountMapper.mapEntityToDto(accountEntity))
        } catch (e: BackendException) {
            if (e.code == 400) throw AccountAlreadyExistsException(e)
            else throw e
        }
    }

    override suspend fun getAccount(): AccountEntity {
        TODO("realized get account" +
                "before: return accountEntityLazyFlowSubject.listen(Unit)")
        //return accountEntityLazyFlowSubject.listen(Unit)
        //return AccountEntity("1", "test")
    }

    override suspend fun logout(): Boolean {
        appSettings.setCurrentUserToken(null)
        accountEntityLazyFlowSubject.updateAllValues(null)
        return true
    }

    private suspend fun doGetAccount(): AccountEntity = wrapBackendExceptions {
        try {
            getAccount()
        } catch (e: BackendException) {
            // account has been deleted = session expired = AuthException
            if (e.code == 400) throw AuthException(e)
            else throw e
        }
    }
}