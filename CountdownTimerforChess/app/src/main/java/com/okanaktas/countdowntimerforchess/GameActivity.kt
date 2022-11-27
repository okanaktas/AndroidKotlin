package com.okanaktas.countdowntimerforchess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.countdowntimerforchess.databinding.ActivityGameBinding
import com.okanaktas.countdowntimerforchess.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}