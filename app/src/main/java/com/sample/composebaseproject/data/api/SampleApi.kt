package com.sample.composebaseproject.data.api

import com.sample.composebaseproject.data.api.model.request.OrderRequest
import com.sample.composebaseproject.data.api.model.request.PetRequest
import com.sample.composebaseproject.data.api.model.request.UserRequest
import com.sample.composebaseproject.data.api.model.response.ApiResponse
import com.sample.composebaseproject.data.api.model.response.OrderResponse
import com.sample.composebaseproject.data.api.model.response.PetResponse
import com.sample.composebaseproject.data.api.model.response.UserResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface SampleApi {
    // Pet API
    @POST("/pet")
    suspend fun addPet(
        @Body petRequest: PetRequest
    ): PetResponse

    @PUT("/pet")
    suspend fun updatePet(
        @Body petRequest: PetRequest
    ): PetResponse

    @GET("/pet/findByStatus")
    suspend fun findPetsByStatus(
        @Query("status") status: String
    ): List<PetResponse>

    @GET("/pet/findByTags")
    suspend fun findPetsByTags(
        @Query("tags") tags: String
    ): List<PetResponse>

    @GET("/pet/{petId}")
    suspend fun getPetById(
        @Path("petId") petId: Long
    ): PetResponse

    @POST("/pet/{petId}")
    suspend fun updatePetWithForm(
        @Path("petId") petId: Long,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null
    )

    @DELETE("/pet/{petId}")
    suspend fun deletePet(
        @Path("petId") petId: Long,
        @Query("api_key") apiKey: String? = null
    )

    @Multipart
    @POST("/pet/{petId}/uploadImage")
    suspend fun uploadFile(
        @Path("petId") petId: Long,
        @Part("additionalMetadata") additionalMetadata: RequestBody? = null,
        @Part file: MultipartBody.Part? = null
    ): ApiResponse

    // Store API
    @GET("/store/inventory")
    suspend fun getInventory(): Map<String, Int>

    @POST("/store/order")
    suspend fun placeOrder(
        @Body orderRequest: OrderRequest
    ): OrderResponse

    @GET("/store/order/{orderId}")
    suspend fun getOrderById(
        @Path("orderId") orderId: Long
    ): OrderResponse

    @DELETE("/store/order/{orderId}")
    suspend fun deleteOrder(
        @Path("orderId") orderId: Long
    )

    // User API
    @POST("/user")
    suspend fun createUser(
        @Body userRequest: UserRequest
    ): UserResponse

    @POST("/user/createWithArray")
    suspend fun createUsersWithArrayInput(
        @Body userRequests: List<UserRequest>
    )

    @POST("/user/createWithList")
    suspend fun createUsersWithListInput(
        @Body userRequests: List<UserRequest>
    )

    @GET("/user/login")
    suspend fun loginUser(
        @Query("username") username: String,
        @Query("password") password: String
    ): String

    @GET("/user/logout")
    suspend fun logoutUser()

    @GET("/user/{username}")
    suspend fun getUserByName(
        @Path("username") username: String
    ): UserResponse

    @PUT("/user/{username}")
    suspend fun updateUser(
        @Path("username") username: String,
        @Body userRequest: UserRequest
    )

    @DELETE("/user/{username}")
    suspend fun deleteUser(
        @Path("username") username: String
    )
}