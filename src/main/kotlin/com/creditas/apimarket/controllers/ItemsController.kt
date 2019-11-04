package com.creditas.apimarket.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1")
class ItemsController {
    @RequestMapping("hola mundo")
    fun HelloWorld():ResponseEntity<Unit>{
        return ResponseEntity<Unit>(HttpStatus.OK)
    }
}