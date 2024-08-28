package com.test.krishna

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.krishna.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    lateinit var mEtUnm : EditText
    lateinit var mEtPwd : EditText
    lateinit var mBtnSignIn: Button
    lateinit var mBtnReset: Button
    lateinit var mBtnSignUp: Button
    lateinit var mSpCountry : Spinner
    lateinit var mRecycleView : RecyclerView

    private val BASE_URL ="https://jsonplaceholder.typicode.com/"
    private val TAG = "MainActivity"

    lateinit var  recycleAdapter : CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_main)
        mEtUnm = findViewById(R.id.id_et_unm)
        mEtPwd = findViewById(R.id.id_et_pwd)
        mBtnSignIn = findViewById(R.id.id_btn_signin)
        mBtnSignUp = findViewById(R.id.id_btn_signup)
        mBtnReset = findViewById(R.id.id_btn_reset)
        mSpCountry = findViewById(R.id.id_spinner_country)
        mRecycleView = findViewById(R.id.id_recycleView)
        getAllComments()
        mBtnSignIn.setOnClickListener {

            val  unm = mEtUnm.text.toString()
            val  pwd = mEtPwd.text.toString()
            if(unm.isEmpty() || pwd.isEmpty()) {
                Toast.makeText(this, " UNM and Pwd not valied",Toast.LENGTH_SHORT).show()
            }
            val pos = mSpCountry.selectedItemPosition
            Log.d("MainActivity",unm+" "+pwd+" "+pos);

        }

        mBtnSignUp.setOnClickListener {

        }

        mBtnReset.setOnClickListener {

        }

        mRecycleView.layoutManager = LinearLayoutManager(this)




    }

    fun getAllComments() {

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        api.getComments().enqueue(object : Callback<List<Comments>> {
            override fun onResponse(p0: Call<List<Comments>>, p1: Response<List<Comments>>) {
                Log.d(TAG,"onResponse  raw "+p1.raw());
                Log.d(TAG,"onResponse  body "+p1.body());

                

                recycleAdapter = CommentsAdapter(p1.body())

                recycleAdapter.setOnClickListener(object : CommentsAdapter.OnClickListener {
                    override fun onClick(position: Int) {

                        Log.d(TAG," OnClick "+position)


                    }


                })

                mRecycleView.adapter = recycleAdapter


            }

            override fun onFailure(p0: Call<List<Comments>>, p1: Throwable) {
                Log.d(TAG,"onFailure "+ p1.message);
            }


        })

    }


}