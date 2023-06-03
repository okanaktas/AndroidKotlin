package com.okanaktas.function

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mySum(4,5)
    }

    fun mySum(a: Int, b: Int){
        print(a+b)
    }
}