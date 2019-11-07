package com.creditas.apimarket.services

import com.creditas.apimarket.domain.entities.Item
import java.util.*

interface I_ItemService {
    fun getItems(): List<Item>
    fun addItem(item: Item): Item
    fun getItemById(Id: Int): Optional<Item>
}