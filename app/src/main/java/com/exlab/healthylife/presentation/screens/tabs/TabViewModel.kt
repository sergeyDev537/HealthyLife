package com.exlab.healthylife.presentation.screens.tabs

import com.exlab.healthylife.app.base.ui.BaseViewModel
import com.exlab.healthylife.app.settings.AppSettings
import com.exlab.healthylife.data.impl.AccountsSourceImpl
import com.exlab.healthylife.utils.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TabViewModel @Inject constructor(
    accountsSourceImpl: AccountsSourceImpl, logger: Logger,
    private val appSettings: AppSettings
) : BaseViewModel(accountsSourceImpl, logger) {

    fun getCurrentUser() = appSettings.getCurrentUserToken()
}
