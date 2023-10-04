package com.okanaktas.whenandforandwhile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // <----- when ----->
        var day = 3
        var dayString = ""

        when (day) {
            1 -> dayString = ("Monday")
            2 -> dayString = ("Tuesday")
            3 -> dayString = ("Wednesday")
            else -> dayString = ""
        }
        println(dayString)

        // <----- for ---->

        var list = arrayListOf<Any>("okan", "berkay", "deneme", 1, 2, 3, 4)

        for (i in list) {
            println("degerler: $i")
        }


        // <------- while ------->
        var j = 0
        while (j < 10) {
            println("j degeri: $j")
            j++
        }


    }
}