package com.okanaktas.foreach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myArrayList = arrayListOf<Any>(1,2,3,"bugra")

        myArrayList.add("okan")
        myArrayList.add(26)
        myArrayList.add("aktas")

        for(i in myArrayList){
            println("Liste icerisindekiler : $i")
        }

        //0 dan 9 a kadar olan rakamları al ve number a ata
        for(number in 0..9){
            println("0 dan 9 a kadar olan rakamlar: $number")
        }
    }
}