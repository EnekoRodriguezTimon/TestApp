package com.eneko.testapp.data.remote


import com.eneko.testapp.data.response.BaseResponse
import com.eneko.testapp.domain.model.Breed
import retrofit2.http.GET

interface BreedApi {
    @GET("breeds")
    suspend fun  getBreeds(): BaseResponse<List<Breed>>
}