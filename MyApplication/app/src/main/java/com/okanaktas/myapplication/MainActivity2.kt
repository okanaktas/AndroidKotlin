package com.okanaktas.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.okanaktas.myapplication.databinding.ActivityMain2Binding
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    lateinit var sharedPref: SharedPreferences
    lateinit var deger: String

    var runnable: Runnable = Runnable {}
    var handler: Handler = Handler()
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication", MODE_PRIVATE)


        if (counter < 10) {
            runnable = object : Runnable {
                override fun run() {
                    binding.textView.setText("Counter: ${counter}")
                    counter++
                    handler.postDelayed(runnable, 1000)
                }

            }
            handler.post(runnable)

            deger = binding.textView.text.toString()

            sharedPref.edit().putString("send", deger).apply()
        }else{
            binding.textView.setText("yanlıs gitti")
            handler.removeCallbacks(runnable)
        }
    }
}