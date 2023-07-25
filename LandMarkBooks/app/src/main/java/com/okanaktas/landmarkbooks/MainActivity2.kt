package com.okanaktas.landmarkbooks

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.landmarkbooks.databinding.ActivityMain2Binding
import com.okanaktas.landmarkbooks.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.landmarkbooks", MODE_PRIVATE)

        var newDeger = sharedPref.getString("deger", "merhaba")
        binding.textView.setText(newDeger.toString())

    }
}