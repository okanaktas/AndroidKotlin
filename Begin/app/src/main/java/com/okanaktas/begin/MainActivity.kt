package com.okanaktas.begin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.begin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler ()

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun buttonStart(view : View){

        runnable = object : Runnable {
            override fun run() {
                binding.textViewTimer.setText("Timer: $number")
                number++

                handler.postDelayed(runnable, 1000)
            }
        }
        handler.post(runnable)


    }

    fun buttonStop(view : View){
        handler.removeCallbacks(runnable)
        binding.textViewTimer.setText("Timer: ")
        //number = 0
    }
}