package com.example.loginauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.loginauth.database.database
import com.example.loginauth.databinding.ActivityMainBinding
import com.example.loginauth.repository.Repository
import com.example.loginauth.viewmodel.LoginViewModel
import com.example.loginauth.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel:LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        setdatabase()
    }

    private fun setdatabase() {
        var repository=Repository(database(this))
        var factory=ViewModelFactory(application,repository)
        mainViewModel=ViewModelProvider(this,factory).get(LoginViewModel::class.java)
    }
}