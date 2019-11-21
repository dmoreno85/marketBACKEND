package com.creditas.apimarket

import com.creditas.apimarket.application.infraestructure.security.JWTAuthorizationFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@SpringBootApplication
class ApimarketApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<ApimarketApplication>(*args)
        }
    }


    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig : WebSecurityConfigurerAdapter() {
        override fun configure(httpSecurity: HttpSecurity) {

            httpSecurity
                    .cors()
                    .and()
                    .csrf().disable()
                    .antMatcher("auth/**")
                    .authorizeRequests() //a partir de aqui te pide el token
                    .anyRequest()
                    .authenticated()
                    .and()
                    .addFilterAfter(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
                    .authorizeRequests()


        }
    }
}