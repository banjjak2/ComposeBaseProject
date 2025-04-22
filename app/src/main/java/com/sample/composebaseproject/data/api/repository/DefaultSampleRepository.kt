package com.sample.composebaseproject.data.api.repository

import com.sample.composebaseproject.data.api.SampleApi
import com.sample.composebaseproject.data.api.model.request.OrderRequest
import com.sample.composebaseproject.data.api.model.request.PetRequest
import com.sample.composebaseproject.data.api.model.request.UserRequest
import com.sample.composebaseproject.data.api.model.response.ApiResponse
import com.sample.composebaseproject.data.api.model.response.OrderResponse
import com.sample.composebaseproject.data.api.model.response.PetResponse
import com.sample.composebaseproject.data.api.model.response.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class DefaultSampleRepository @Inject constructor(
    private val sampleApi: SampleApi
) : SampleRepository {
    // Pet API
    override fun addPet(petRequest: PetRequest): Flow<PetResponse> = flow {
        val response = sampleApi.addPet(petRequest)
        emit(response)
    }

    override fun updatePet(petRequest: PetRequest): Flow<PetResponse> = flow {
        val response = sampleApi.updatePet(petRequest)
        emit(response)
    }

    override fun findPetsByStatus(status: String): Flow<List<PetResponse>> = flow {
        val response = sampleApi.findPetsByStatus(status)
        emit(response)
    }

    override fun findPetsByTags(tags: String): Flow<List<PetResponse>> = flow {
        val response = sampleApi.findPetsByTags(tags)
        emit(response)
    }

    override fun getPetById(petId: Long): Flow<PetResponse> = flow {
        val response = sampleApi.getPetById(petId)
        emit(response)
    }

    override fun updatePetWithForm(
        petId: Long,
        name: String?,
        status: String?
    ): Flow<Unit> = flow {
        sampleApi.updatePetWithForm(petId, name, status)
        emit(Unit)
    }

    override fun deletePet(petId: Long, apiKey: String?): Flow<Unit> = flow {
        sampleApi.deletePet(petId, apiKey)
        emit(Unit)
    }

    override fun uploadFile(
        petId: Long,
        additionalMetadata: RequestBody?,
        file: MultipartBody.Part?
    ): Flow<ApiResponse> = flow {
        val response = sampleApi.uploadFile(petId, additionalMetadata, file)
        emit(response)
    }

    // Store API
    override fun getInventory(): Flow<Map<String, Int>> = flow {
        val response = sampleApi.getInventory()
        emit(response)
    }

    override fun placeOrder(orderRequest: OrderRequest): Flow<OrderResponse> = flow {
        val response = sampleApi.placeOrder(orderRequest)
        emit(response)
    }

    override fun getOrderById(orderId: Long): Flow<OrderResponse> = flow {
        val response = sampleApi.getOrderById(orderId)
        emit(response)
    }

    override fun deleteOrder(orderId: Long): Flow<Unit> = flow {
        sampleApi.deleteOrder(orderId)
        emit(Unit)
    }

    // User API
    override fun createUser(userRequest: UserRequest): Flow<UserResponse> = flow {
        val response = sampleApi.createUser(userRequest)
        emit(response)
    }

    override fun createUsersWithArrayInput(userRequests: List<UserRequest>): Flow<Unit> = flow {
        sampleApi.createUsersWithArrayInput(userRequests)
        emit(Unit)
    }

    override fun createUsersWithListInput(userRequests: List<UserRequest>): Flow<Unit> = flow {
        sampleApi.createUsersWithListInput(userRequests)
        emit(Unit)
    }

    override fun loginUser(username: String, password: String): Flow<String> = flow {
        val response = sampleApi.loginUser(username, password)
        emit(response)
    }

    override fun logoutUser(): Flow<Unit> = flow {
        sampleApi.logoutUser()
        emit(Unit)
    }

    override fun getUserByName(username: String): Flow<UserResponse> = flow {
        val response = sampleApi.getUserByName(username)
        emit(response)
    }

    override fun updateUser(
        username: String,
        userRequest: UserRequest
    ): Flow<Unit> = flow {
        sampleApi.updateUser(username, userRequest)
        emit(Unit)
    }

    override fun deleteUser(username: String): Flow<Unit> = flow {
        sampleApi.deleteUser(username)
        emit(Unit)
    }
}