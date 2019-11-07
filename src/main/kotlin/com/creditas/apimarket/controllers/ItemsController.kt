package com.creditas.apimarket.controllers

import com.creditas.apimarket.domain.entities.Item
import com.creditas.apimarket.services.I_ItemService
import com.creditas.apimarket.services.implementation.ItemsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.logging.Logger


@RestController
@RequestMapping("api/v1")
class ItemsController {
    @Autowired
    private lateinit var itemService: I_ItemService

    @CrossOrigin(origins = ["http://localhost:3000"]) //Para autenticar CORS
    @RequestMapping("items", "GET", "application/json")

    fun getPatients(): ResponseEntity<List<Item>> = ResponseEntity(itemService.getItems(), HttpStatus.OK)

    @CrossOrigin(origins = ["http://localhost:3000"]) //Para autenticar CORS
    @PostMapping("items")
    fun addItem(@RequestBody item: Item): ResponseEntity<Item> {
        val result: Item = itemService.addItem(item)
        return ResponseEntity(result, HttpStatus.OK)
    }
    @GetMapping("items/{id}")
    fun getItemById(@PathVariable id:Int): ResponseEntity<Item>
    {
        val result: Optional<Item> = itemService.getItemById(id)

        return result.map {res-> ResponseEntity(res, HttpStatus.OK)}
                .orElse(ResponseEntity(HttpStatus.NO_CONTENT))

    }

//    @GetMapping("/{id}")
//    fun getItemById(@PathVariable("id") Id: Int): Item? =
//            itemService.getItemById(Id)


}