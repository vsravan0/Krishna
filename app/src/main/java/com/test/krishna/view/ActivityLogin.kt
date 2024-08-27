package com.test.krishna.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.test.krishna.R
import com.test.krishna.databinding.LayoutLoginBinding
import com.test.krishna.util.AuthListener
import com.test.krishna.util.toast
import com.test.krishna.viewmodel.AuthViewModel

class ActivityLogin : ComponentActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        val binding : LayoutLoginBinding = DataBindingUtil.setContentView(this, R.layout.layout_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel;
        viewModel.authListener= this

    }

    override fun onStarted() {

        toast("onStarted")

    }

    override fun onSuccess() {
        toast("onSuccess")
    }

    override fun onFailure() {
        toast("onFailure")
    }
}