package com.okanaktas.myapplication4

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication4", MODE_PRIVATE)


    }
    fun buttonGo(view : View){

        sharedPref.edit().putString("gidenDeger",binding.editTextName.text.toString()).apply()

        var intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}