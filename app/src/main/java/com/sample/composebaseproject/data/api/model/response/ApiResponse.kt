package com.sample.composebaseproject.data.api.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val code: Int? = null,
    val type: String? = null,
    val message: String? = null
) 