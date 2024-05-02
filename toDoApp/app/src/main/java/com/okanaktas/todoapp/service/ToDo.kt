package com.okanaktas.todoapp.service

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ToDo (
    @ColumnInfo(name = "mail")
    var mail :String,

    @ColumnInfo(name = "password")
    var password : Int
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}