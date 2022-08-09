package com.okanaktas.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.intent.databinding.ActivityMain2Binding
import com.okanaktas.intent.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val Intent = intent

        val inputName = intent.getStringExtra("name")
        val inputSurName =  intent.getStringExtra("SurName")

        binding.textViewInputName.setText("Name: ${inputName}")
        binding.textViewInputSurName.setText("SurName: ${inputSurName}")

    }
}