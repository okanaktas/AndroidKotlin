package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var number1 : Int? = null
    var number2 : Int? =null
    var result : Int? =null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }

    fun buttonSum(view : View){
        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()

        result = number1!!+ number2!!

    }
}