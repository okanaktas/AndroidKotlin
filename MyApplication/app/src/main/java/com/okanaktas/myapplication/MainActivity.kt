package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var runabble: Runnable = Runnable {}
    var handler: Handler = Handler()

    var input = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




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
    }

    fun buttonCounter(view: View) {
        input = binding.editTextNumber.text.toString().toInt()

        runabble = object : Runnable {
            override fun run() {
                binding.textViewCounter.setText("Counter: $input")
                input--
                handler.postDelayed(runabble, 1000)
            }
        }
        binding.buttonCounter.isEnabled = false
        handler.post(runabble)
    }
    fun buttonStop(view: View){
        handler.removeCallbacks(runabble)
        input = 0
        binding.textViewCounter.setText("Counter: ")
        binding.buttonCounter.isEnabled = true
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

    //database update

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