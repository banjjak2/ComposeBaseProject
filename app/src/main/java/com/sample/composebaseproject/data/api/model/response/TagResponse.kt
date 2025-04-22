package com.sample.composebaseproject.data.api.model.response

import kotlinx.serialization.Serializable

@Serializable
data class TagResponse(
    val id: Long? = null,
    val name: String? = null
) 