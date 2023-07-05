package com.example.growigh

import com.example.growigh.dataclass.Images
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

object RetrofitGet {


    private const val BASE_URL = "https://api.unsplash.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    interface ApiService {
        @Headers("Content-Type: application/json" , "Accept-Version: v1")
        @GET("photos")
        suspend fun getRandomImages(
            @Query("client_id") clientId: String
        ): List<Images>
    }
}