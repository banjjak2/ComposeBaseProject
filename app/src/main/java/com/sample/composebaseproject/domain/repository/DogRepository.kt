package com.sample.composebaseproject.domain.repository

import kotlinx.coroutines.flow.Flow

interface DogRepository {
    fun getBreedImages(breedName: String): Flow<List<String>>
} 