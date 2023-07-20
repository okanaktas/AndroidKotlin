package com.okanaktas.catchthekennyagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.okanaktas.catchthekennyagain.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var score = 0
    var imageArray = arrayListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.imageView0)
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)

        binding.textViewScore.setText("Score: ${score}")

        hideImage()
    }

    fun hideImage() {
        for(image in imageArray){
            image.visibility = View.INVISIBLE
        }
        val random = Random()
    }

    fun buttonDonatello(view: View) {
        score++
        binding.textViewScore.setText("Score: ${score}")
    }
}