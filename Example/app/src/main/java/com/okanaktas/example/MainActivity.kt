package com.okanaktas.example

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.example", MODE_PRIVATE)

    }
    fun buttonSend(view : View){
        var intent = Intent(this@MainActivity,MainActivity2::class.java)
       // intent.putExtra("deger",binding.editText.text.toString())
        startActivity(intent)

        sharedPref.edit().putString("deger", binding.editText.text.toString()).apply()
    }
}