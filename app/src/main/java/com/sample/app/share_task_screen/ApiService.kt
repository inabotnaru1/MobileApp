package com.sample.app.share_task_screen

import com.sample.app.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {

    @GET("users")
    fun fetchData(): Call<List<User>>

    @POST("users")
    fun postData(
        @Body user: User
    ): Call<User>

    companion object {
        fun create() : ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

}