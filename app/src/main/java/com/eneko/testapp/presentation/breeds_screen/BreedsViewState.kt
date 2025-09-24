package com.eneko.testapp.presentation.breeds_screen

import com.eneko.testapp.domain.model.Breed


data class BreedsViewState (
    val isLoading: Boolean = false,
    val breeds: List<Breed> = emptyList(),
    val error: String? = null,
)