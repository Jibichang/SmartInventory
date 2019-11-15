package org.lox.smartinventory.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIUtils {

    val BASE_URL = "http://10.35.147.180:8080/SmartInvService/"
//    val BASE_URL = "http://localhost:8080/AndroidService/rest/Android_Service/"

    //http://localhost:8080/AndroidService/rest/Android_Service/
    //http://localhost:8080/SmartInvService/
    val apiService: APIService
        get() = RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)
}

object RetrofitClient {
    private var retrofit: Retrofit? = null
    fun getClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}