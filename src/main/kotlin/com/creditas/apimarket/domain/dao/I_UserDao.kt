package com.creditas.apimarket.domain.dao

import com.creditas.apimarket.domain.entities.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface I_UserDao : CrudRepository <User, String> {
    fun findByEmail(email: String) : Optional<User>


}