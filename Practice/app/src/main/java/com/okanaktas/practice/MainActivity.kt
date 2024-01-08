package com.okanaktas.practice

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.okanaktas.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("com.okanaktas.practice", MODE_PRIVATE)


    }

    fun buttonSend(view: View) {

    }

    fun buttonDeneme(view : View){

        if(binding.radioButtonEasy.isChecked){
            binding.textViewDeneme.setText("Selected Easy")
        }
        else if(binding.radioButtonMedium.isChecked){
            binding.textViewDeneme.setText("Selected Medium")
        }
        else if(binding.radioButtonHard.isChecked){
            binding.textViewDeneme.setText("Selected Hard")
        }
        else{
            binding.textViewDeneme.setText("Nothing")
        }

    }
}