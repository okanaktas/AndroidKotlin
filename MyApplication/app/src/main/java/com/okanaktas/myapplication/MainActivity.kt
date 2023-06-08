package com.okanaktas.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var sayi = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sayi = 5
    }

    fun buttonGo(view: View) {

        val intent = Intent(this, YedekActivity::class.java)

        intent.putExtra("deger",sayi.toString())


        startActivity(intent)

    }
}