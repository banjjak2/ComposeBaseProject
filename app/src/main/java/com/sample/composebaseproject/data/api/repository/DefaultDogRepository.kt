package com.sample.composebaseproject.data.api.repository

import com.sample.composebaseproject.data.api.DogApi
import com.sample.composebaseproject.domain.repository.DogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultDogRepository @Inject constructor(
    private val dogApi: DogApi
) : DogRepository {
    override fun getBreedImages(breedName: String): Flow<List<String>> = flow {
        val response = dogApi.getBreedImages(breedName)
        emit(response.message)
    }
} 