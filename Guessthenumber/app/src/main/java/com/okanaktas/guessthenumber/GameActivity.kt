package com.okanaktas.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.guessthenumber.databinding.ActivityGameBinding
import com.okanaktas.guessthenumber.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    var runnable: Runnable = Runnable {}
    var handler: Handler = Handler()

    var timer = 61

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (timer > 0) {
            runnable = object : Runnable {
                override fun run() {
                    timer--
                    binding.textViewTimer.setText("Timer: $timer")
                    handler.postDelayed(runnable, 1000)
                }
            }
            handler.post(runnable)
        }
        else{
            binding.textViewInfo.setText("Süre Bitti! ")
            binding.buttonSend.isEnabled = false
        }
    }


    fun buttonSend(view: View) {

    }
}