package com.test.krishna.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.test.krishna.util.AuthListener

class AuthViewModel : ViewModel() {


    var email: String? = null
    var pwd: String? = null
    val TAG ="AuthViewModel";
    var authListener : AuthListener? = null

    fun onLoginButtonClick(v : View) {
        if(email.isNullOrEmpty() || pwd.isNullOrEmpty()) {
            Log.d(TAG,"onLoginButtonClick username or password is empty -> "+authListener)
            authListener?.onFailure()
            return
        } else {
            Log.d(TAG,"onLoginButtonClick username or password not empty -> "+authListener)
            authListener?.onSuccess()
        }

    }
}