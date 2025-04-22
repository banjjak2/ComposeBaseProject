package com.sample.composebaseproject.data.api.model.request

import com.sample.composebaseproject.data.api.model.response.OrderResponse
import com.sample.composebaseproject.data.api.model.serializer.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class OrderRequest(
    val id: Long? = null,
    val petId: Long? = null,
    val quantity: Int? = null,
    @Serializable(with = LocalDateTimeSerializer::class)
    val shipDate: LocalDateTime? = null,
    val status: OrderResponse.Status? = null,
    val complete: Boolean? = null
) 