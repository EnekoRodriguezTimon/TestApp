package com.eneko.testapp.data.repository

import com.eneko.testapp.data.local.daos.ItemDao
import com.eneko.testapp.data.local.mapper.toDomain
import com.eneko.testapp.data.local.mapper.toEntity
import com.eneko.testapp.domain.model.Item
import com.eneko.testapp.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val dao: ItemDao
) : ItemRepository {

    override fun getItems(): Flow<List<Item>> {
        return dao.getAll().map { entityList ->
            entityList.map { it.toDomain() }
        }
    }

    override suspend fun addItem(item: Item) {
        dao.insert(item.toEntity())
    }

    override suspend fun deleteItem(item: Item) {
        dao.delete(item.toEntity())
    }
}