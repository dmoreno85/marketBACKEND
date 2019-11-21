package com.creditas.apimarket.services.implementation

import com.creditas.apimarket.services.IServiceAuth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

import java.util.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest

@Service
class ServiceAuthImpl() : IServiceAuth {


    lateinit var secretKey: String

    override fun getJWT(user: String, request: HttpServletRequest): String {
        val grantedAuthorities: List<GrantedAuthority> = commaSeparatedStringToAuthorityList("ROLE_USER")

        val token: String = Jwts
                .builder()
                .claim("ip", request.getRemoteAddr())
                .setId("Creditas")
                .setSubject(user)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + 6))
                .signWith(SignatureAlgorithm.HS512, "bragasdeesparto".toByteArray()).compact()


        return "Bearer " + token
    }

}