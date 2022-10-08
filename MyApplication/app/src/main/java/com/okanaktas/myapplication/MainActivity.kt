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


        try {

            val database = this.openOrCreateDatabase("Home", MODE_PRIVATE, null)
            database.execSQL("CREATE TABLE IF NOT EXISTS birol(name VARCHAR,number INT)")
            database.execSQL("INSERT INTO birol (name, number) VALUES('aybuke',22)")

            val cursor = database.rawQuery("SELECT * FROM birol",null)

            val index1 = cursor.getColumnIndex("name")
            var index2 = cursor.getColumnIndex("number")

            while (cursor.moveToNext()){
                println("Gelen isim degeri: " + cursor.getString(index1))
                println("Gelen Sayi  degeri: " + cursor.getString(index2))
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }


        /*try {
            val myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age INT)")
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
*/
    }
}