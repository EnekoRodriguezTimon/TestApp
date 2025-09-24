package com.eneko.testapp.presentation.breeds_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eneko.testapp.domain.usecase.breed.BreedListUseCase
import com.eneko.testapp.presentation.util.sendEvent
import com.eneko.testapp.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel @Inject constructor(
    private  val breedListUseCase: BreedListUseCase
): ViewModel() {

    private val _state = MutableStateFlow(BreedsViewState())
    val state = _state.asStateFlow()

    init{
        getBreeds()
    }

    fun getBreeds(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            breedListUseCase()
                .onRight {products ->
                    _state.update {
                        it.copy(breeds = products)
                    }
                }.onLeft { error ->
                    _state.update {
                        it.copy(error = error.error.message)
                    }
                    sendEvent(Event.Toast(error.error.message))
                }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}