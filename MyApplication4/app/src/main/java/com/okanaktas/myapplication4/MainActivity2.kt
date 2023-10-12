package com.okanaktas.myapplication4

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.myapplication4.databinding.ActivityMain2Binding
import com.okanaktas.myapplication4.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication4", MODE_PRIVATE)

        binding.textView.setText(sharedPref.getString("gidenDeger","Deger Gelmedi").toString())


    }
}