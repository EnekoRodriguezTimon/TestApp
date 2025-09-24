package com.eneko.testapp.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eneko.testapp.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}