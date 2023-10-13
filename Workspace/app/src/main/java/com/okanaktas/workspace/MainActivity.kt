package com.okanaktas.workspace

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.okanaktas.workspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var runnable: Runnable = Runnable {}
    var handler: Handler = Handler()

    var sayac = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


    }

    fun buttonStart(view: View) {

        runnable = object : Runnable {
            override fun run() {
                binding.textView.setText("Counter: ${sayac}")
                sayac++
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.post(runnable)
    }
}