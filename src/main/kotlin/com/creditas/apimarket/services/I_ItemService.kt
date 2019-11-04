package com.creditas.apimarket.services

import com.creditas.apimarket.domain.entities.Item

interface I_ItemService {
    fun getItems():List<Item>
}