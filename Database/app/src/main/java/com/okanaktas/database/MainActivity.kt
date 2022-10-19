package com.okanaktas.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id, INTEGER PRIMARY KEY,name VARCHAR, age INT)")
            myDatabase.execSQL("INSERT INTO musicians (name , age) VALUES ('Okan' ,26)")

            val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)

            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")

            while(cursor.moveToNext()){
                println("Gelen Name Degeri: " + cursor.getString(nameIx))
                println("Gelen Age Degeri: " + cursor.getInt(ageIx))
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}