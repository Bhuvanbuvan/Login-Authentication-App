package com.example.loginauth.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loginauth.model.datamodel

@Database(entities = [datamodel::class], version = 1)
abstract class database :RoomDatabase() {
    abstract fun ado(): userDAO

    //singleton
    companion object{
        @Volatile
        private var instence:database?=null
        private val lock=Any()



        operator fun invoke(context: Context)= instence?:
        synchronized(lock){
            instence?:
            createdabase(context).also {
                instence=it
            }
        }

        private fun createdabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,database::class.java,"logindatabase"
        ).build()
    }



}