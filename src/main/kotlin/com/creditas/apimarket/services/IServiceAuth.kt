package com.creditas.apimarket.services

import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest


interface IServiceAuth {
    fun getJWT(user: String, request: HttpServletRequest): String

}