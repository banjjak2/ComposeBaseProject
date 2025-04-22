package com.sample.composebaseproject.data.api.model.response

import com.sample.composebaseproject.data.api.model.serializer.LocalDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class OrderResponse(
    val id: Long? = null,
    val petId: Long? = null,
    val quantity: Int? = null,
    @Serializable(with = LocalDateTimeSerializer::class)
    val shipDate: LocalDateTime? = null,
    val status: Status? = null,
    val complete: Boolean? = null
) {
    @Serializable
    enum class Status {
        @SerialName("placed")
        PLACED,
        @SerialName("approved")
        APPROVED,
        @SerialName("delivered")
        DELIVERED
    }
} 