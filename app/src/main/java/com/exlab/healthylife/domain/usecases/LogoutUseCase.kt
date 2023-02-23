package com.exlab.healthylife.domain.usecases

import com.exlab.healthylife.domain.repositories.AccountsSource

class LogoutUseCase(private val accountsSource: AccountsSource) {

    suspend operator fun invoke(){
        accountsSource.logout()
    }

}