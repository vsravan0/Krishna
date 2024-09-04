package com.test.krishna.util

import androidx.lifecycle.LiveData
import com.test.krishna.data.db.entities.Comments

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure()
    fun onCommentsDataReceived(commentsResponse : LiveData<String>)

    fun onCommentsListReceived(commentsResponse : LiveData<List<Comments>>)
    }