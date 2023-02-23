package com.exlab.healthylife.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.exlab.healthylife.app.base.ui.BaseViewModel
import com.exlab.healthylife.data.impl.AccountsSourceImpl
import com.exlab.healthylife.utils.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    accountsSourceImpl: AccountsSourceImpl, logger: Logger
) : BaseViewModel(accountsSourceImpl, logger) {
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1500)
            _isLoading.value = false
        }
    }

    fun isSignedIn() = accountsSourceImpl.isSignedIn()
}