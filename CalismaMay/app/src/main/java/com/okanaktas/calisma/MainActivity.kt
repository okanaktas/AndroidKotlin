package com.okanaktas.calisma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //arrayListOf
        val arrayOkan = arrayListOf<Any>()

        arrayOkan.add("bugra")
        arrayOkan.add("okan")
        arrayOkan.add(30)
        arrayOkan.add("aktas")

        println("Dizi degerleri ${arrayOkan}")



    }
}