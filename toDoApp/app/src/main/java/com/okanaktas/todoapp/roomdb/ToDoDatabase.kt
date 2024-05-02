package com.okanaktas.todoapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okanaktas.todoapp.service.ToDo


@Database(entities = [ToDo::class], version = 1)
abstract class UuidDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}