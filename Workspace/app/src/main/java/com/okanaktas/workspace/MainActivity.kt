package com.okanaktas.workspace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.okanaktas.workspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        try {

            val database = this.openOrCreateDatabase("Person", MODE_PRIVATE, null)
            database.execSQL("CREATE TABLE IF NOT EXISTS person (id INTEGER PRIMARY KEY, name VARCHAR, age INT)")
            database.execSQL("INSERT INTO person (name, age) VALUES ('Okan',27) ")

            val cursor = database.rawQuery("SELECT * FROM person", null)

            val idIx = cursor.getColumnIndex("id")
            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")

            while (cursor.moveToNext()) {
                println("Id : ${cursor.getInt(idIx)}")
                println("Name: ${cursor.getString(nameIx)}")
                println("Age: ${cursor.getInt(ageIx)}")
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }


    }
}