package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//public place
        try {
            val database = this.openOrCreateDatabase("Office", MODE_PRIVATE, null)

            database.execSQL("CREATE TABLE IF NOT EXISTS person (id INTEGER PRIMARY KEY, name VARCHAR ,age INT)")
            database.execSQL("INSERT INTO person (name, age)VALUES('okan',27)")

            var cursor = database.rawQuery("SELECT * FROM person", null)

            var nameIX = cursor.getColumnIndex("name")
            var ageIX = cursor.getColumnIndex("age")

            //imleç cursor
            while () {
                print("First value: " + cursor.getString(nameIX))
                print("Second value: " + cursor.getString(ageIX))
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun buttonStart(view : View){}
    fun buttonStop(view : View){}
}