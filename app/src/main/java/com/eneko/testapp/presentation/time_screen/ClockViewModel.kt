package com.eneko.testapp.presentation.time_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClockViewModel @Inject constructor(): ViewModel() {

    private var _timeMillis by mutableLongStateOf(System.currentTimeMillis())

    val timeMillis: Long get() = _timeMillis

    init {
        // Update time each second
        viewModelScope.launch {
            while (true) {
                _timeMillis = System.currentTimeMillis()
                delay(1000L)
            }
        }
    }
}