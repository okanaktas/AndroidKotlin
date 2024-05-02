package com.okanaktas.todoapp.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.okanaktas.todoapp.service.ToDo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo")
    fun getAll(): Flowable<List<ToDo>>

    @Insert
    fun insert(toDo: ToDo): Completable

    @Delete
    fun delete(toDo: ToDo): Completable


}