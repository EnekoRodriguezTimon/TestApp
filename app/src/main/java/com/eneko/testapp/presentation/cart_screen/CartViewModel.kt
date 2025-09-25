package com.eneko.testapp.presentation.cart_screen

import androidx.lifecycle.viewModelScope
import com.eneko.testapp.domain.model.Item
import com.eneko.testapp.domain.repository.ItemRepository
import com.eneko.testapp.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: ItemRepository
): BaseViewModel() {

    private val _items = repository.getItems()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val items: StateFlow<List<Item>> = _items



    fun addItem(name: String, quantity: Int) {
        viewModelScope.launch {
            repository.addItem(Item(id = 0, name = name, quantity = quantity))
            showResultDialog(true)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            repository.deleteItem(item)
            showResultDialog(true)
        }
    }
}