package com.example.loginauth.repository

import com.example.loginauth.database.database
import com.example.loginauth.database.userDAO
import com.example.loginauth.model.datamodel

class Repository(private var db:database) {

    suspend fun insert(dataModel: datamodel)=db.ado().insert(dataModel)

    fun getData()=db.ado().selectAll()
    fun authenticate(uname:String,pwd:String):List<datamodel> =db.ado().authenticate(uname,pwd)
}