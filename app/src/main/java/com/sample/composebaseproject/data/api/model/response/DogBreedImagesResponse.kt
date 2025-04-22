package com.sample.composebaseproject.data.api.model.response

import kotlinx.serialization.Serializable

@Serializable
data class DogBreedImagesResponse(
    val status: String,
    val message: List<String>
) 