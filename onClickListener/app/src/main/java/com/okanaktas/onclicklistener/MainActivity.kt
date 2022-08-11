package com.okanaktas.onclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.okanaktas.onclicklistener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonListener.setOnClickListener {
            binding.textView.setText("Button Listener")
        }

    }

    fun buttonFunction(view: View) {
        binding.textView.setText("Button Funciton")
    }

}