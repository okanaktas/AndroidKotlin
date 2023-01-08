package com.okanaktas.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.guessthenumber.databinding.ActivityGameBinding
import com.okanaktas.guessthenumber.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler()

    var timer = 61

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        runnable = object : Runnable{
            override fun run() {
                timer--
                binding.textViewTimer.setText("Timer: " )
            }
        }

    }



    fun buttonSend(view : View){

    }
}