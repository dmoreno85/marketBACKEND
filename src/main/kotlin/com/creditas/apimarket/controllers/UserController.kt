package com.creditas.apimarket.controllers

import com.creditas.apimarket.domain.entities.User
import com.creditas.apimarket.services.I_UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1")
class UserController {
    @Autowired
    private lateinit var userService: I_UserService

    @CrossOrigin(origins = ["http://localhost:3000"]) //Para autenticar CORS
    @RequestMapping("users", "GET", "application/json")
    fun getUser(): ResponseEntity<List<User>> = ResponseEntity(userService.getUser(), HttpStatus.OK)

    @CrossOrigin(origins = ["http://localhost:3000"]) //Para autenticar CORS
    @PostMapping("users")
    fun addUser(@RequestBody user: User): ResponseEntity<User> {
        val result: User = userService.addUser(user)
        return when(result) {
            null ->  ResponseEntity(result, HttpStatus.BAD_REQUEST)
            else -> ResponseEntity(result, HttpStatus.CREATED)
        }
    }
}