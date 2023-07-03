package com.okanaktas.shareddeneme

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.shareddeneme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.shareddeneme", MODE_PRIVATE)

        var newDeger = sharedPref.getString("deger","Merhaba")
        binding.textViewResult.setText(newDeger)

    }
    fun buttonGo(view : View){
        var intent = Intent(this, InputActivity::class.java)
        startActivity(intent)
    }
}