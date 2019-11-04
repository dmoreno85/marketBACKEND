package com.creditas.apimarket.controllers

import com.creditas.apimarket.domain.entities.Item
import com.creditas.apimarket.services.I_ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1")
class ItemsController {
    @Autowired
    private lateinit var itemService: I_ItemService

    @RequestMapping("hola")
    fun HelloWorld(): ResponseEntity<Unit> {
        return ResponseEntity<Unit>(HttpStatus.OK)
    }

    @RequestMapping("items", "GET", "application/json")

    fun getPatients(): ResponseEntity<List<Item>> = ResponseEntity(itemService.getItems(), HttpStatus.OK)

    @PostMapping("items")
    fun addItem(@RequestBody item: Item):ResponseEntity<Item>{
        val result:Item = itemService.addItem(item)
        return ResponseEntity(result,HttpStatus.OK)
    }
}