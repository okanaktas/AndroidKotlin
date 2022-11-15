package com.okanaktas.forwardcounterandreversecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.okanaktas.forwardcounterandreversecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var runnable: Runnable = Runnable {}
    var handler: Handler = Handler()

    var counter = 0

    var inputNumber = 0

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

    fun buttonReverse(view: View) {

        if (binding.editTextNumber.text.isEmpty()) {
            Toast.makeText(applicationContext, "Entry Number!", Toast.LENGTH_LONG).show()
        } else {

            inputNumber = binding.editTextNumber.text.toString().toInt()

            runnable = object : Runnable {
                override fun run() {
                    binding.textViewReverse.setText("Reverse Counter: $inputNumber")
                    inputNumber--
                    handler.postDelayed(runnable, 1000)
                }
            }
            handler.post(runnable)
            binding.buttonReverse.isEnabled = false
        }
    }

    fun buttonStopReverse(view: View) {
        handler.removeCallbacks(runnable)
        binding.buttonStopReverse.isEnabled = true
        inputNumber = 0
        binding.textViewReverse.setText("Reverse Counter: ")
        binding.editTextNumber.setText("")
    }
}