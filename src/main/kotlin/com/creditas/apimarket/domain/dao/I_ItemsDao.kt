package com.creditas.apimarket.domain.dao

import com.creditas.apimarket.domain.entities.Item
import org.springframework.data.repository.CrudRepository
import java.util.*

interface I_ItemsDao : CrudRepository<Item, Int> {


    public fun findByModel(model: String): Optional<Item>
}