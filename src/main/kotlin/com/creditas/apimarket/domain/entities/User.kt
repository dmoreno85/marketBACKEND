package com.creditas.apimarket.domain.entities

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="users")
data class User(
        @Id
        @GeneratedValue
        var user: String,
        var password: String,
        var email: String,
        @NotNull
        var created_at: LocalDateTime?,
        var update_at: LocalDateTime?

)