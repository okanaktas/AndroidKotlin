package com.okanaktas.permissionsforimagestorageartbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.permissionsforimagestorageartbook.databinding.ActivityArtBinding
import com.okanaktas.permissionsforimagestorageartbook.databinding.ActivityMainBinding

class ArtActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun buttonSave(view: View) {

    }

    fun saveImage(view: View) {

    }
}