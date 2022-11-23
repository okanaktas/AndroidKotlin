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

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


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

    }

    fun buttonStart(view: View) {

        runnable = object : Runnable {
            override fun run() {

                binding.textViewCounter.setText("Counter: $counter")
                counter++
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.post(runnable)
        binding.buttonStart.isEnabled = false

    }

    fun buttonStop(view: View) {
        handler.removeCallbacks(runnable)
        counter = 0
        binding.buttonStart.isEnabled = true
    }
}