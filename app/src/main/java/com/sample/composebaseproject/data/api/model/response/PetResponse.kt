package com.sample.composebaseproject.data.api.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PetResponse(
    val id: Long? = null,
    val category: CategoryResponse? = null,
    val name: String,
    val photoUrls: List<String>,
    val tags: List<TagResponse>? = null,
    val status: Status? = null
) {
    @Serializable
    enum class Status {
        @SerialName("available")
        AVAILABLE,
        @SerialName("pending")
        PENDING,
        @SerialName("sold")
        SOLD
    }
} 