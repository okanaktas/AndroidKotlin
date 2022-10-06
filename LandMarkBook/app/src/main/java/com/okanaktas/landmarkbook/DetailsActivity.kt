package com.okanaktas.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.landmarkbook.databinding.ActivityDetailsBinding
import com.okanaktas.landmarkbook.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val selectedLandMark = intent.getSerializableExtra("landMark") as LandMark


        binding.textViewName.text = selectedLandMark.name
        binding.textViewCountry.text = selectedLandMark.country
        binding.imageView.setImageResource(selectedLandMark.image)

    }
}