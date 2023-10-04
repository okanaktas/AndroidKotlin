package com.okanaktas.arraylistofandsetof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayList = arrayListOf<Any>("Okan",27)
        println("First element: ${arrayList[0]}")

        var setList = setOf<Any>(1,1,2,3)

        print(setList.size)

        //setList içerisindekileri lambda ile foreach kullanarak ekrana bastırma
        setList.forEach { println(it) }
    }
}