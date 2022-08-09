package com.okanaktas.nullable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Nullable && Non-Null

        var myString: String? = null
        var myAge: Int? = null

        // 1) Null Safety

        if (myAge != null) {
            println(myAge * 10)
        } else {
            println("myAge is Null")
        }

        // 2) Safe Call

        println(myAge?.compareTo(2))

        // 3) Elvis

        val myResult = myAge?.compareTo(2) ?: -100

        println(myResult)
    }
}