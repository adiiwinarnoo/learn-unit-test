package com.example.belajarunittest.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.belajarunittest.model.ResponseLogin
import com.example.belajarunittest.network.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel (val loginRepo : LoginRepository) : ViewModel() {

    var dataLogin = MutableLiveData<ResponseLogin>()
    var statusLogin : String? = null

    fun loginVM(user : String, password : String) : String {
        loginRepo.login(user,password){
           if (it.message.equals("Login cuy")) statusLogin = "Login berhasil"
            else statusLogin = "Login default"
        }
        return statusLogin.toString()
    }

    fun login(user: String,password: String, callback: (String) -> Unit)  {
        viewModelScope.launch {
            loginRepo.loginOI(user,password) {
                callback(it)
            }
        }
    }

    fun loginMock(user: String,password: String) : String {
        var status = "default"
        if (user.equals("adiw1234") && password.equals("12345")){
            status = "berhasil"
        }else{
            status = "gagal"
        }
        return status
    }


}