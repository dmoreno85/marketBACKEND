package com.creditas.apimarket.controllers

import com.creditas.apimarket.domain.entities.Item
import com.creditas.apimarket.services.I_ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


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

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("items/{id}")
    fun getItemById(@PathVariable id: Int): ResponseEntity<Item> {
        val result: Optional<Item> = itemService.getItemById(id)

        return result.map { res -> ResponseEntity(res, HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NO_CONTENT))

    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("search/{model}")
    fun getItemByModel(@PathVariable model: String): ResponseEntity<Item> {
        val result: Optional<Item> = itemService.getItemByModel(model)

        return result.map { res -> ResponseEntity(res, HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NO_CONTENT))

    }


}