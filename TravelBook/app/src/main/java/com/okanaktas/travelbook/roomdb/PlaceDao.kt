package com.okanaktas.travelbook.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.okanaktas.travelbook.model.Place

@Dao
interface PlaceDao {

    @Query("SELECT * FROM Place")
    //getAll fonksiyonu hepsini al anlamında ve bu bana bir liste dondurecek geriye ve listenin icinde de place ler olacak
    fun getAll(): List<Place>

    @Insert
    fun insert(place : Place)

    @Delete
    fun delete(place : Place)

}