package com.creditas.apimarket.services

import com.creditas.apimarket.domain.entities.User
import java.util.*


interface I_UserService {
    fun getUser(): List<User>
    fun addUser(user: User): User
    fun getUserByEmail(email: String): Optional<User>
}