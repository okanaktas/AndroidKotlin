package com.okanaktas.workspace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.workspace.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        var intent = intent
        var incomingName = intent.getStringExtra("name")
        var incomingPassword = intent.getStringExtra("password")

        binding.textViewName.setText(incomingName.toString())
        binding.textViewPassword.setText(incomingPassword.toString())

    }
}