package com.exlab.healthylife.domain.repositories

import com.exlab.healthylife.domain.entities.AccountEntity

interface AccountsSource {

    suspend fun signIn(email: String, password: String)

    suspend fun signUp(accountEntity: AccountEntity)

    suspend fun getAccount(): AccountEntity

    suspend fun logout(): Boolean

}