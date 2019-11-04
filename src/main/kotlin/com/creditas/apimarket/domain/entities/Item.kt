package com.creditas.apimarket.domain.entities


import java.time.LocalDateTime
import javax.persistence.*


@Entity
data class Item(
        @Id
        @GeneratedValue
        var id: Int?,
        var model: String?,
        var price: Int?,
        var color: String?,
        var stockUnits: Int?,
        var created_at: LocalDateTime?,
        var update_at: LocalDateTime?
)