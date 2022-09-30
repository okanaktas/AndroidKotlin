package com.okanaktas.calisma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.calisma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val myEmployees=Employees()

        myEmployees.name = "okan"
        myEmployees.age = 26

        println(myEmployees.age)


    }
}