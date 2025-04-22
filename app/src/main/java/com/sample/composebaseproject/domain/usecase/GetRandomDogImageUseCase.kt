package com.sample.composebaseproject.domain.usecase

import com.sample.composebaseproject.domain.repository.DogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRandomDogImageUseCase @Inject constructor(
    private val dogRepository: DogRepository
) {
    operator fun invoke(): Flow<String> = dogRepository.getBreedImages("hound")
        .map { images ->
            if (images.isEmpty()) ""
            else images.random()
        }
} 