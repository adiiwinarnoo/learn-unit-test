package com.example.belajarunittest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiConfig {

//    var tokenAuth = TokenInterceptor(Constant.TOKEN_USER)
//    var client = OkHttpClient.Builder().addInterceptor(tokenAuth).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.addictioncompany.co.kr")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var server : ApiService = retrofit.create(ApiService::class.java)
}