package com.okanaktas.myapplication3

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication3", MODE_PRIVATE)


    }

    fun buttonSave(view: View) {

        var okan = Aktas(binding.editTextName.text.toString(), "Aktas", 27)
        var berkay = Aktas(binding.editTextName.text.toString(), "Aktas", 10)

        sharedPref.edit().putString("okan", okan.name.toString()).apply()
        sharedPref.edit().putString("okan", berkay.name.toString()).apply()

        var intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}