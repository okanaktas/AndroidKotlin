package com.okanaktas.runnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.okanaktas.runnable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var number = 0
    var runnable : Runnable = Runnable{ }
    var handler : Handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun buttonStart(view: View){

        runnable = object : Runnable{
            override fun run() {
                number++
                binding.textView.setText("Time: ${number }")

                handler.postDelayed(runnable,1000) //runnable yerine this de yazabilirdik çünkü
                //this şu an runnable a referans veriyor.
            }
        }
        handler.post(runnable )
        binding.buttonStart.isEnabled = false

    }

    fun buttonStop(view: View){
        handler.removeCallbacks(runnable)
        number = 0
        binding.textView.setText("Time: $number")
        binding.buttonStart.isEnabled = true
    }


}