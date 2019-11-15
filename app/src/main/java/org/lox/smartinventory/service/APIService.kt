package org.lox.smartinventory.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {

    @get:GET("texttest")
    val texttest: Call<String>

    @POST("passparamservice")
    fun testPassParam(@Body text: String):
    //@FormUrlEncoded
     Call<String>

}