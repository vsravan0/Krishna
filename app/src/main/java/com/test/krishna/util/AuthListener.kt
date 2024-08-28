package com.test.krishna.util

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure()
    fun onCommentsDataReceived(commentsResponse : LiveData<String>)
    }