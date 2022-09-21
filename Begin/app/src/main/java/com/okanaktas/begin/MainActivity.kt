package com.okanaktas.begin

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.okanaktas.begin.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val imageArray = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.imageViewB10)
        imageArray.add(binding.imageViewB2)
        imageArray.add(binding.imageViewB3)
        imageArray.add(binding.imageViewB4)
        imageArray.add(binding.imageViewB5)
        imageArray.add(binding.imageViewB6)
        imageArray.add(binding.imageViewB7)
        imageArray.add(binding.imageViewB8)
        imageArray.add(binding.imageViewB9)
        imageArray.add(binding.imageViewBA)
        imageArray.add(binding.imageViewBJ)
        imageArray.add(binding.imageViewBK)
        imageArray.add(binding.imageViewBQ)

    }

    fun buttonChoose(view: View) {

        hideImages()

    }

    fun hideImages() {

        binding.imageViewGameImage.visibility = View.INVISIBLE
        
        for (i in imageArray) {
            i.visibility = View.INVISIBLE
        }

        val random = Random()
        val randomNumber = random.nextInt(12)
        imageArray[randomNumber].visibility = View.VISIBLE

    }

}
