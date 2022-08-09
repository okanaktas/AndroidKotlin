package com.okanaktas.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }

    fun buttonIntent(view : View){
        val intent = Intent(applicationContext,MainActivity2::class.java)
        intent.putExtra("name", binding.editTextTextPersonName.text.toString())
        intent.putExtra("SurName", binding.editTextTextPersonName2.text.toString())
        startActivity(intent)
    }
}