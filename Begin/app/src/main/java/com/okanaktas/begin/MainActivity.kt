package com.okanaktas.begin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.begin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val myArrayList = arrayListOf<Any>()

        myArrayList.add("Bugra")
        myArrayList.add("Bugra")
        myArrayList.add("Okan")
        myArrayList.add(26)

        println("Liste Elemanları: ${myArrayList.size}")

        println("merhaba dunya")

        val hastSet = hashSetOf<Any>()

        hastSet.add("Yasin")
        hastSet.add("Yasin")
        hastSet.add(45)

        println("hashset Elemanları: ${hastSet.size}")

    }
}