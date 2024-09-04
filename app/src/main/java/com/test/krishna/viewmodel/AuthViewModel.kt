package com.test.krishna.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.test.krishna.data.repositories.UserRepository
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

     fun onCommentsButtonClick(v : View) {
         Log.d(TAG,"onCommentsButtonClick ")
         authListener?.onStarted()
         val commentsResponse = UserRepository().loadComments()
        Log.d(TAG,"UserRepository loadComments "+commentsResponse)
        authListener?.onCommentsDataReceived(commentsResponse)
     }

    fun onCommentsListButtonClick(v : View) {
        Log.d(TAG,"onCommentsListButtonClick ")
        authListener?.onStarted()
        val commentsResponse = UserRepository().loadCommentsList()
        Log.d(TAG,"UserRepository loadComments "+commentsResponse)
        authListener?.onCommentsListReceived(commentsResponse)
    }


}