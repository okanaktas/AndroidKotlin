package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.myapplication.databinding.ActivityYedekBinding

class YedekActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYedekBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYedekBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent

        val newDeger = intent.getStringExtra("deger")

        binding.textViewShow.setText(newDeger)
    }
}