package com.okanaktas.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.okanaktas.myapplication", MODE_PRIVATE)

        var gelenDeger = sharedPreferences.getString("deger","Deger Gelmedi")

        binding.textView.setText(gelenDeger.toString())
    }

}