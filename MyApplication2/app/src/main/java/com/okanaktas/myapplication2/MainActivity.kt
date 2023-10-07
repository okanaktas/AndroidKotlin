package com.okanaktas.myapplication2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication2", MODE_PRIVATE)

    }

    fun buttonGo(view: View) {
        var gelenDeger = binding.editText.text.toString()
        sharedPref.edit().putString("deger", gelenDeger).apply()
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}