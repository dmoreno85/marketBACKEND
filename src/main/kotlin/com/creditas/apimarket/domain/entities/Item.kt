package com.creditas.apimarket.domain.entities


import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name="items")
data class Item(
        @Id
        @GeneratedValue
        var id: Int?,
        var model: String?,
        var price: Int?,
        var color: String?,
        var stockUnits: Int?,
        var path: String?,
        @NotNull
        var created_at: LocalDateTime?,
        var update_at: LocalDateTime?
)