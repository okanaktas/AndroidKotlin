package com.okanaktas.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.landmarkbook.databinding.ActivityDetailsBinding
import com.okanaktas.landmarkbook.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


    }
}