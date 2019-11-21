package com.creditas.apimarket.controllers

import com.creditas.apimarket.domain.entities.User
import com.creditas.apimarket.services.I_UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
//@RequestMapping("api/v1")
class UserController {
    @Autowired
    private lateinit var userService: I_UserService

    @CrossOrigin(origins = ["http://localhost:3000"])
    @RequestMapping("/auth/users", "GET", "application/json")
    fun getUser(): ResponseEntity<List<User>> = ResponseEntity(userService.getUser(), HttpStatus.OK)


    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/auth/users")
    fun addUser(@RequestBody user: User): ResponseEntity<User> {
        val result: User = userService.addUser(user)
        return when(result) {
            null ->  ResponseEntity(result, HttpStatus.BAD_REQUEST)
            else -> ResponseEntity(result, HttpStatus.CREATED)
        }
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/auth/users/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<User> {
        val result: Optional<User> = userService.getUserByEmail(email)

        return result.map { res -> ResponseEntity(res, HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }
}