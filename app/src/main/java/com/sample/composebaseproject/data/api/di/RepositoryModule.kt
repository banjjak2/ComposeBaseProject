package com.sample.composebaseproject.data.api.di

import com.sample.composebaseproject.data.api.repository.DefaultSampleRepository
import com.sample.composebaseproject.data.api.repository.SampleRepository
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
}