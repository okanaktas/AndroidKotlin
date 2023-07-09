package com.okanaktas.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication", MODE_PRIVATE)

        var newDeger = sharedPref.getString("send","Default deger")
        binding.textViewGoster.setText("Gelen Deger: ${newDeger.toString()}")

    }
    fun buttonGo(view : View){
        var intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }
}