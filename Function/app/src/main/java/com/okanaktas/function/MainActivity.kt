package com.okanaktas.function

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mySum(4,5)
        myMultipy(2,6 )
    }

    fun mySum(a: Int, b: Int){
        print(a+b)
    }
    fun myMultipy(a: Int, b:Int) : Int {
        return a*b
    }
}