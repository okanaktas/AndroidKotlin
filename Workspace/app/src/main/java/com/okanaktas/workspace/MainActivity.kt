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

            val myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age INT)")

            myDatabase.execSQL("INSERT INTO musicians(name, age) VALUES ('Okan',27) ")

            val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)

            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")

            while (cursor.moveToNext()) {
                println("Name: " + cursor.getString(nameIx))
                println("Age: " + cursor.getInt(ageIx))
            }

            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {

            val database = this.openOrCreateDatabase("Person", MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS person (name VARCHAR,age INT)")
            database.execSQL("INSERT INTO okan(name,age) VALUES ('okan',27)")

            val cursor = database.rawQuery()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}