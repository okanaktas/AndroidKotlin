package com.okanaktas.example

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.example.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.example", MODE_PRIVATE)

        var gelenDeger = sharedPref.getString("deger","Okan")
        binding.textView.setText(gelenDeger.toString())

       /* var intent = intent
        var deger = intent.getStringExtra("deger")
        binding.textView.setText(deger.toString())
        */
    }
}