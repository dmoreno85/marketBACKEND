package com.creditas.apimarket.domain.dao

import com.creditas.apimarket.domain.entities.Item
import org.springframework.data.repository.CrudRepository

interface I_ItemsDao: CrudRepository<Item, Int> {
}