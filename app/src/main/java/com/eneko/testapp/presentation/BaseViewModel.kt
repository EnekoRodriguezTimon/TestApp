package com.eneko.testapp.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


abstract class BaseViewModel : ViewModel() {

    private val _showResultDialog = MutableStateFlow(false)

    val showResultDialog: StateFlow<Boolean> = _showResultDialog.asStateFlow()
    private val _isSuccessResultDialog = MutableStateFlow(true)

    val isSuccessResultDialog: StateFlow<Boolean> = _isSuccessResultDialog.asStateFlow()


    fun showResultDialog(success: Boolean) {
        _showResultDialog.value = true
        _isSuccessResultDialog.value = success
    }

    fun hideResultDialog() {
        _showResultDialog.value = false
    }

}


