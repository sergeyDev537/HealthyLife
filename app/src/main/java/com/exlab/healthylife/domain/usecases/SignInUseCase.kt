package com.exlab.healthylife.domain.usecases

import com.exlab.healthylife.domain.repositories.AccountsSource

class SignInUseCase(private val accountsSource: AccountsSource) {

    suspend operator fun invoke(email: String, password: String){
        accountsSource.signIn(email, password)
    }

}