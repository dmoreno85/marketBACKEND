package com.creditas.apimarket.services.implementation


import com.creditas.apimarket.domain.dao.I_UserDao
import com.creditas.apimarket.domain.entities.User
import com.creditas.apimarket.services.I_UserService
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : I_UserService {

    @Autowired
    private lateinit var userDao: I_UserDao

    override fun addUser(user: User): User = userDao.save(user)

    override fun getUser(): List<User> {
        return userDao.findAll() as List<User>
    }
    override fun getUserByEmail(email: String): Optional<User> {
        return userDao.findByEmail(email)
    }



}
