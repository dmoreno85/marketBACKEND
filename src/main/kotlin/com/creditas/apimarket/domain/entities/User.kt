package com.creditas.apimarket.domain.entities

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        var user: String?,
        var password: String?,
        var email: String?,
        @NotNull
        var created_at:LocalDateTime= LocalDateTime.now(),
        var update_at: LocalDateTime?

)