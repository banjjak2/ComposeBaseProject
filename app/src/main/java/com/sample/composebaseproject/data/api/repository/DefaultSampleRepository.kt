package com.sample.composebaseproject.data.api.repository

import com.sample.composebaseproject.data.api.SampleApi
import javax.inject.Inject

class DefaultSampleRepository @Inject constructor(
    private val sampleApi: SampleApi
) : SampleRepository {

}