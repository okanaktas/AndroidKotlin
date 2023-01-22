package com.okanaktas.kotlinsqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.kotlinsqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        try {

            val myDatabase = this.openOrCreateDatabase("Class", Context.MODE_PRIVATE, null)

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS person (name VARCHAR, age INT) ")

            myDatabase.execSQL("INSERT INTO person(name, age) VALUES ('okan',27)")

            val cursor = myDatabase.rawQuery("SELECT * FROM person", null)

            val nameIX = cursor.getColumnIndex("name")
            val ageIX = cursor.getColumnIndex("age")

            while (cursor.moveToNext()/*cursor gezebildiği kadar gez*/) {
                println("Name: " + cursor.getString(nameIX))
                println("Age: " + cursor.getInt(ageIX))
            }
            cursor.close() 


        } catch (e: Exception) {
            e.printStackTrace()
        }


    }
}