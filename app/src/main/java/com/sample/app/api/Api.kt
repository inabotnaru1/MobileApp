package com.sample.app.api

import retrofit2.Call
import retrofit2.http.*


interface Api {

    @GET("users")
    fun fetchData(): Call<List<SpecificData>>

    @POST("posts")
    fun postData(
        @Body testData: TestData
    ): Call<TestData>

}