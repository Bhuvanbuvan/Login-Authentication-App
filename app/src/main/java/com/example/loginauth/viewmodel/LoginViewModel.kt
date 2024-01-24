package com.example.loginauth.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginauth.model.datamodel
import com.example.loginauth.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(app:Application, private var repository: Repository):AndroidViewModel(app) {

    fun insert(datamodel: datamodel)=viewModelScope.launch {
        repository.insert(datamodel)
    }

    fun selectall()=repository.getData()

    suspend fun authenticate(username: String, password: String): List<datamodel> {
        return withContext(Dispatchers.IO) {
            repository.authenticate(username, password)
        }
    }



}

