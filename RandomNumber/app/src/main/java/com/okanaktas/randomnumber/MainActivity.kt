package com.okanaktas.randomnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.randomnumber.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val random = Random()
        random.nextInt(9) // 0 dan 9 a kadar olan sayıları verir. 9 dahil değil

    }
}