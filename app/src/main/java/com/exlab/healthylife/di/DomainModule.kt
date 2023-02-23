package com.exlab.healthylife.di

import com.exlab.healthylife.domain.repositories.AccountsSource
import com.exlab.healthylife.domain.usecases.GetAccountUseCase
import com.exlab.healthylife.domain.usecases.LogoutUseCase
import com.exlab.healthylife.domain.usecases.SignInUseCase
import com.exlab.healthylife.domain.usecases.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideSignInUseCase(accountsSource: AccountsSource): SignInUseCase{
        return SignInUseCase(accountsSource)
    }

    @Provides
    @Singleton
    fun provideSignUpUseCase(accountsSource: AccountsSource): SignUpUseCase{
        return SignUpUseCase(accountsSource)
    }

    @Provides
    @Singleton
    fun provideGetAccountUseCase(accountsSource: AccountsSource): GetAccountUseCase{
        return GetAccountUseCase(accountsSource)
    }

    @Provides
    @Singleton
    fun provideLogoutUseCase(accountsSource: AccountsSource): LogoutUseCase{
        return LogoutUseCase(accountsSource)
    }

}