package com.okanaktas.myapplication2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.myapplication2.databinding.ActivityMain2Binding
import com.okanaktas.myapplication2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication2", MODE_PRIVATE)
        var newDeger = sharedPref.getString("deger", "Deger Gelmedi")

        binding.textView2.setText("Gelen deger: ${newDeger}")


    }
}