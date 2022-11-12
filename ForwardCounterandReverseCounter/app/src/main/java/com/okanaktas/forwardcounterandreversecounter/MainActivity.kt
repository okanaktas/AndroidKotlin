package com.okanaktas.forwardcounterandreversecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import com.okanaktas.forwardcounterandreversecounter.databinding.ActivityMainBinding

class MainActivity(millisInFuture: Long) : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var runnable: Runnable = Runnable {}
    var handler: Handler = Handler()

    var counter = 0;

    var downCounter = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun buttonForward(view: View) {
        runnable = object : Runnable {
            override fun run() {
                binding.textViewForward.setText("Forward Counter: $counter")
                counter++
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.post(runnable)
        binding.buttonForward.isEnabled = false
    }

    fun buttonStopForward(view: View) {
        binding.buttonForward.isEnabled = true
        handler.removeCallbacks(runnable)
        counter = 0
        binding.textViewForward.setText("Forward Counter: ")
    }

    fun buttonReverse(view: View) {/*
        downCounter = Integer.parseInt(binding.editText.text.toString())

        object : CountDownTimer(1000,  100) {
            override fun onTick(downCounter: Long) {
                binding.textViewReverse.setText("Reverse Counter: $downCounter/1000")
            }

            override fun onFinish() {
                binding.textViewReverse.setText("Reverse Counter: Finished!")
            }
        }*/
    }

    fun buttonStopReverse(view: View) {/*
        binding.buttonStopReverse.isEnabled = true
        binding.textViewForward.setText("Reverse Counter: ")
    */}
}