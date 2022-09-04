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

        val myAray = arrayListOf<Any>()

        myAray.add("bugra")
        myAray.add("okan")
        myAray.add(26)

        for(i in myAray){
            println(i)
        }


    }
}