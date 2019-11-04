package com.creditas.apimarket.services.implementation

import com.creditas.apimarket.domain.dao.I_ItemsDao
import com.creditas.apimarket.domain.entities.Item
import com.creditas.apimarket.services.I_ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
 class ItemsServiceImpl : I_ItemService {


    @Autowired
    private lateinit var  itemDao : I_ItemsDao
    override fun getItems(): List<Item> {
        return itemDao.findAll() as List<Item>
    }

    override fun addItem(item: Item): Item {
       return itemDao.save(item)
    }

}