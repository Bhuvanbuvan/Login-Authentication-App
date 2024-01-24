package com.example.loginauth.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginauth.repository.Repository

class ViewModelFactory(private var app:Application,private var repository: Repository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(app,repository) as T
    }

}