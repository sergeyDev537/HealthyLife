package com.exlab.healthylife.domain.usecases

import com.exlab.healthylife.domain.repositories.AccountsSource
import com.exlab.healthylife.domain.entities.AccountEntity

class GetAccountUseCase(private val accountsSource: AccountsSource) {

    suspend operator fun invoke(): AccountEntity {
        return accountsSource.getAccount()
    }

}