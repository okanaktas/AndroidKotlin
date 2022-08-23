package com.okanaktas.citylandmarks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.citylandmarks.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val landmark = intent.getSerializableExtra("landmark") as Landmark
        binding.textName.text = landmark.name
        binding.textCountry.text = landmark.country
        binding.imageView.setImageResource(landmark.image)

    }
}