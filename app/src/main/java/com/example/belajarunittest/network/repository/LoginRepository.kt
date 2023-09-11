package com.example.belajarunittest.network.repository

import com.example.belajarunittest.model.ResponseLogin
import com.example.belajarunittest.network.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    val apiConfig = ApiConfig()
    var textLogin = ""

    interface LoginCallback {
        fun onLoginSuccess()
        fun onLoginFailure()
    }

    fun login(user : String, password : String, onResult : (result : ResponseLogin)-> Unit) {
        apiConfig.server.login(user,password).enqueue(object : Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful){
                    val authError = "Login cuy"
                    val default = ResponseLogin(message = authError)
                    onResult(default)
//                   textLogin = "Login berhasil"
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                val authError = "Login gagal"
                val default = ResponseLogin(message = authError)
                onResult(default)
            }
        })
    }

    suspend fun loginOI(user: String, password: String,callback: (String) -> Unit){
        return withContext(Dispatchers.IO){
            try {
                apiConfig.server.login(user,password).execute()
                callback("Login berhasil")
            }catch (e : Throwable){
                callback("Login gagal2")
            }
        }
    }

}