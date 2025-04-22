package com.sample.composebaseproject.data.api.model.request

import com.sample.composebaseproject.data.api.model.response.CategoryResponse
import com.sample.composebaseproject.data.api.model.response.PetResponse
import com.sample.composebaseproject.data.api.model.response.TagResponse
import kotlinx.serialization.Serializable

@Serializable
data class PetRequest(
    val id: Long? = null,
    val category: CategoryResponse? = null,
    val name: String,
    val photoUrls: List<String>,
    val tags: List<TagResponse>? = null,
    val status: PetResponse.Status? = null
) 