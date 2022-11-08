package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var runnable: Runnable = Runnable {}
    var handler: Handler = Handler()

    var timer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//update    
        try {

            val myDatase = this.openOrCreateDatabase("Home", MODE_PRIVATE, null)

            myDatase.execSQL("CREATE TABLE IF NOT EXISTS person (name VARCHAR, age INT)")
            myDatase.execSQL("INSERT INTO person(name , age) VALUES ('aybuke, 22')")

            val cursor = myDatase.rawQuery("SELECT * FROM person", null)

            val nameIX = cursor.getColumnIndex("name")
            var ageIX = cursor.getColumnIndex("age")

            while (cursor.moveToNext()) {
                println("Name Info: " + nameIX)
                println("Age Info: " + ageIX)
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        /*
        try {

            val myDatabase = this.openOrCreateDatabase("School", MODE_PRIVATE, null)

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS person (name VARCHAR, age INT)")
            myDatabase.execSQL("INSERT INTO person (name, age) VALUES ('aybuke',22)")

            var cursor = myDatabase.rawQuery("SELECT * FROM person", null)

            val nameIX = cursor.getColumnIndex("name")
            var ageIX = cursor.getColumnIndex("age")

            while (cursor.moveToNext()) {
                println("Birinci deger: " + cursor.getString(nameIX))
                println("Ikinci deger: " + cursor.getInt(ageIX))
            }
            cursor.close()


        } catch (e: Exception) {
            e.printStackTrace()
        }
*/

        /*
        try {

            val myDatabase = this.openOrCreateDatabase("School", MODE_PRIVATE, null)

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS class(name VARCHAR, age INT)")
            myDatabase.execSQL("INSERT INTO class(name, age) VALUES ('okan',26)")

            val cursor = myDatabase.rawQuery("SELECT * FROM class", null)

            val nameIX = cursor.getColumnIndex("name")
            val ageIX = cursor.getColumnIndex("age")

            while (cursor.moveToNext()) {
                println("Values of first: " + cursor.getString(nameIX))
                println("Values of second: " + cursor.getInt(ageIX))
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
*/
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

    fun buttonClick(view: View) {

        runnable = object : Runnable {
            override fun run() {
                binding.textViewTimer.setText("Timer: ${timer}")
                handler.postDelayed(runnable, 1000)
                timer++
            }
        }
        handler.post(runnable)
        binding.buttonClick.isEnabled = false

    }
//buttonStop
    fun buttonStop(view: View) {
        handler.removeCallbacks(runnable)
        timer = 0
        binding.textViewTimer.setText("Timer: $timer")
        binding.buttonClick.isEnabled = true

    }
}