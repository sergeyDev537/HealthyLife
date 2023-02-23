package com.exlab.healthylife.di

import com.exlab.healthylife.app.base.network.RetrofitConfig
import com.exlab.healthylife.app.settings.AppSettings
import com.exlab.healthylife.data.impl.AccountsSourceImpl
import com.exlab.healthylife.data.mappers.AccountMapper
import com.exlab.healthylife.data.network.api.AccountsApi
import com.exlab.healthylife.domain.repositories.AccountsSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAccountsSource(
        config: RetrofitConfig,
        accountsApi: AccountsApi,
        accountMapper: AccountMapper,
        appSettings: AppSettings
    ): AccountsSource {
        return AccountsSourceImpl(config,accountsApi, accountMapper, appSettings)
    }


    @Provides
    @Singleton
    fun provideAccountsApi(retrofit: Retrofit): AccountsApi = retrofit.create(AccountsApi::class.java)

}