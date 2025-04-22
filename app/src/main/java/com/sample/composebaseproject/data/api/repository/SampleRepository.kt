package com.sample.composebaseproject.data.api.repository

import com.sample.composebaseproject.data.api.model.request.OrderRequest
import com.sample.composebaseproject.data.api.model.request.PetRequest
import com.sample.composebaseproject.data.api.model.request.UserRequest
import com.sample.composebaseproject.data.api.model.response.ApiResponse
import com.sample.composebaseproject.data.api.model.response.OrderResponse
import com.sample.composebaseproject.data.api.model.response.PetResponse
import com.sample.composebaseproject.data.api.model.response.UserResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface SampleRepository {
    // Pet API
    fun addPet(petRequest: PetRequest): Flow<PetResponse>
    fun updatePet(petRequest: PetRequest): Flow<PetResponse>
    fun findPetsByStatus(status: String): Flow<List<PetResponse>>
    fun findPetsByTags(tags: String): Flow<List<PetResponse>>
    fun getPetById(petId: Long): Flow<PetResponse>
    fun updatePetWithForm(petId: Long, name: String? = null, status: String? = null): Flow<Unit>
    fun deletePet(petId: Long, apiKey: String? = null): Flow<Unit>
    fun uploadFile(petId: Long, additionalMetadata: RequestBody? = null, file: MultipartBody.Part? = null): Flow<ApiResponse>

    // Store API
    fun getInventory(): Flow<Map<String, Int>>
    fun placeOrder(orderRequest: OrderRequest): Flow<OrderResponse>
    fun getOrderById(orderId: Long): Flow<OrderResponse>
    fun deleteOrder(orderId: Long): Flow<Unit>

    // User API
    fun createUser(userRequest: UserRequest): Flow<UserResponse>
    fun createUsersWithArrayInput(userRequests: List<UserRequest>): Flow<Unit>
    fun createUsersWithListInput(userRequests: List<UserRequest>): Flow<Unit>
    fun loginUser(username: String, password: String): Flow<String>
    fun logoutUser(): Flow<Unit>
    fun getUserByName(username: String): Flow<UserResponse>
    fun updateUser(username: String, userRequest: UserRequest): Flow<Unit>
    fun deleteUser(username: String): Flow<Unit>
}