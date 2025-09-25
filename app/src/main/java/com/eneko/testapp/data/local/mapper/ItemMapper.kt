package com.eneko.testapp.data.local.mapper

import com.eneko.testapp.data.local.entities.ItemEntity
import com.eneko.testapp.domain.model.Item

fun ItemEntity.toDomain() = Item(id, name, quantity)
fun Item.toEntity() = ItemEntity(id, name, quantity)