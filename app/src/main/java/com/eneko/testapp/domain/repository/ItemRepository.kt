package com.eneko.testapp.domain.repository

import com.eneko.testapp.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun getItems(): Flow<List<Item>>
    suspend fun addItem(item: Item)
    suspend fun deleteItem(item: Item)
}