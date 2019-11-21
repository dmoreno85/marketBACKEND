package com.creditas.apimarket.controllers

import com.creditas.apimarket.domain.dao.I_UserDao
import com.creditas.apimarket.domain.entities.User
import com.creditas.apimarket.services.IServiceAuth
import com.creditas.apimarket.services.I_UserService
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class AuthController {
    private var Logger = LogFactory.getLog("AuthController.class")
    @Autowired
    private lateinit var userService : I_UserService
    @Autowired
    lateinit var serviceJWT: IServiceAuth
    @Autowired
    private lateinit var userDao: I_UserDao

    @PostMapping("/auth")
    @CrossOrigin(origins = ["http://localhost:3000"])
    fun login(@RequestBody user: User, request: HttpServletRequest): ResponseEntity<Any> {
        Logger.warn("dentro de login")

        var result = userDao.findByEmail(user.email!!)
        if (!result.isPresent) return ResponseEntity("Datos Incorrecto", HttpStatus.NOT_FOUND)
        if (!user.password.equals(result.get().password)) return ResponseEntity("Datos Incorrecto", HttpStatus.NOT_FOUND)

        Logger.warn(result)

        var token: String = serviceJWT.getJWT(result.get().email as String, request)

        return ResponseEntity(token, HttpStatus.OK)

    }

//    @PostMapping("purchase/found")
//
//    fun addPurchaseItem(@RequestBody user: User): ResponseEntity<User> {
//        val result: User = userService.addUser(user)
//        return ResponseEntity(result, HttpStatus.OK)
//    }
}