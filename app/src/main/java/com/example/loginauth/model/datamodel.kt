package com.example.loginauth.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "table_login")
@Parcelize
data class datamodel(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var username: String,
    var password: String
    ):Parcelable
