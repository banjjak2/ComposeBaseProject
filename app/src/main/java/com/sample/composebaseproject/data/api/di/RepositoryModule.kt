package com.sample.composebaseproject.data.api.di

import com.sample.composebaseproject.data.api.repository.*
import com.sample.composebaseproject.domain.repository.DogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsSampleRepository(
        sampleRepository: DefaultSampleRepository
    ): SampleRepository
    
    @Binds
    @Singleton
    abstract fun bindsDogRepository(
        dogRepository: DefaultDogRepository
    ): DogRepository
}