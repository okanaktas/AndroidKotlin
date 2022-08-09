package com.okanaktas.classesandfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = Person("okan","aktas",26)

        person.hairColor = "Yellow"

        println(person.name)
        println(person.hairColor)
    }
}