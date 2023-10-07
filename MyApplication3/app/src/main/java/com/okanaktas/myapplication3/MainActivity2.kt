package com.okanaktas.myapplication3

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.myapplication3.databinding.ActivityMain2Binding
import com.okanaktas.myapplication3.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication3", MODE_PRIVATE)

        var okan = sharedPref.getString("okan","Okan degeri gelmedi")
        var berkay = sharedPref.getString("berkay","Berkay degeri gelmedi")

        binding.textViewOkan.setText("Gelen Deger: ${okan.toString().trim()}")
        binding.textViewBerkay.setText("Gelen Deger: ${berkay.toString().trim()}")



    }
}