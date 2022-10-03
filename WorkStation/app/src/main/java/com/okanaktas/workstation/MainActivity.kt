package com.okanaktas.workstation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.okanaktas.workstation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var person = Person("okan","Aktas",26)

        var people = People("berkay","Aktas",12)

        people.sing()

        //lambda
        val multiplyLambda = {number1 : Int, number2 : Int -> number1 + number2}


    }
}