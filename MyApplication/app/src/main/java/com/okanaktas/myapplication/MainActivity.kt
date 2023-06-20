package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var runnable: Runnable = Runnable {}
    var runnableCounter: Runnable = Runnable {}
    var handler: Handler = Handler()

    var deger: Int = 0
    var counter: Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Saniye hızı
        runnableCounter = object : Runnable {
            override fun run() {
                handler.postDelayed(runnableCounter, 1000)
                counter-=100
            }
        }
        handler.post(runnableCounter)

        //Normal sayı sayma
        runnable = object : Runnable {
            override fun run() {
                handler.postDelayed(runnable, counter.toLong())
                deger++
                binding.textView.setText("Number: $deger")
            }
        }
        handler.post(runnable)
    }
}