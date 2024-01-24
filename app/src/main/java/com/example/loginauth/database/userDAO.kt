package com.example.loginauth.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.loginauth.model.datamodel

@Dao
interface userDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(datamodel: datamodel)

    @Query("SELECT * FROM  table_login ORDER BY id DESC")
    fun selectAll():LiveData<List<datamodel>>

    @Query("SELECT * FROM TABLE_LOGIN WHERE username Like:username AND password LIKE:password")
    fun authenticate(username: String,password:String):List<datamodel>
}