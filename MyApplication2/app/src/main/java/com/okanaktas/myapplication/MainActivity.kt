package com.okanaktas.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication", MODE_PRIVATE)


    }

    fun buttonGo(view: View) {
        var intent = Intent(this@MainActivity, MainActivity2::class.java)
        sharedPref.edit().putString("deger", binding.editTextText.text.toString()).apply()

        startActivity(intent)
    }
}