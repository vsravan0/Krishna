package com.test.krishna.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.krishna.data.db.entities.Comments
import com.test.krishna.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

   val TAG = "UserRepository"

    fun loadComments() : LiveData<String> {



        Log.d(TAG,"loadComments");

        val commentsResponse = MutableLiveData<String>()

        MyApi().getCommentsData().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d(TAG,"onResponse");
                if(response.isSuccessful) {
                    commentsResponse.value = response.body()?.string()
                    Log.d(TAG,"onResponse success");
                } else {
                    commentsResponse.value = response.errorBody()?.string()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(TAG,"onFailure "+t.message);
                commentsResponse.value = t.message
            }
        })
        return  commentsResponse
    }


    fun loadCommentsList() : LiveData<List<Comments>> {
        Log.d(TAG,"loadCommentsList");
        val commentsResponse = MutableLiveData<List<Comments>>()



        MyApi().getComments().enqueue(object : Callback<List<Comments>> {
            override fun onResponse(call: Call<List<Comments>>, response: Response<List<Comments>>) {
                Log.d(TAG,"onResponse");
                if(response.isSuccessful) {
                    commentsResponse.value = response.body()
                    Log.d(TAG,"onResponse success");
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.d(TAG,"onFailure "+t.message);
            }
        })
        return  commentsResponse
    }
}