package com.creditas.apimarket.services

import com.creditas.apimarket.domain.entities.User


interface I_UserService {


    fun getUser(): List<User>
    fun addUser(user: User): User
}