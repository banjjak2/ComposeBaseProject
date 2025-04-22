package com.sample.composebaseproject.data.api

import com.sample.composebaseproject.data.api.model.response.DogBreedImagesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {
    @GET("breed/{breedName}/images")
    suspend fun getBreedImages(@Path("breedName") breedName: String): DogBreedImagesResponse
} 