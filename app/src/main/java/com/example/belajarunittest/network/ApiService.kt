package com.example.belajarunittest.network

import com.example.belajarunittest.model.ResponseLogin
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("/api/company/login")
    fun login(
        @Field("account_id") accountId : String,
        @Field("account_pwd") accountPwd : String,
    ) : retrofit2.Call<ResponseLogin>

}