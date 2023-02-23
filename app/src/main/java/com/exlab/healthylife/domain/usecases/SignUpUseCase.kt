package com.exlab.healthylife.domain.usecases

import com.exlab.healthylife.domain.repositories.AccountsSource
import com.exlab.healthylife.domain.entities.AccountEntity

class SignUpUseCase(private val accountsSource: AccountsSource) {

    suspend operator fun invoke(accountEntity: AccountEntity){
        accountsSource.signUp(accountEntity)
    }

}