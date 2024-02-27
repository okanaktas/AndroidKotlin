package com.okanaktas.landmarksbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.landmarksbook.databinding.ActivityDetailsBinding
import com.okanaktas.landmarksbook.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
    }
}