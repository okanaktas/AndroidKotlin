package com.okanaktas.catchcartooncharacters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.catchcartooncharacters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun buttonStart(view: View) {
        val intent = Intent(applicationContext, GameActivity::class.java)
        intent.putExtra("inputValue", binding.editTextTime.text.toString())
        intent.putExtra("name", binding.editTextPlayer.text.toString())
        startActivity(intent)
    }

}