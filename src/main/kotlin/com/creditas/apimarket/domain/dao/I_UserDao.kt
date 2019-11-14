package com.creditas.apimarket.domain.dao

import com.creditas.apimarket.domain.entities.User
import org.springframework.data.repository.CrudRepository

interface I_UserDao : CrudRepository <User, String> {
}