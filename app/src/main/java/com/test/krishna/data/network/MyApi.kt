package com.test.krishna.data.network

import com.test.krishna.Comments
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("comments")
    fun getComments() : Call<List<Comments>>


    @GET("comments")
    fun getCommentsData() : Call<ResponseBody>

    companion object {

        operator fun invoke(): MyApi {

            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }

    }


}