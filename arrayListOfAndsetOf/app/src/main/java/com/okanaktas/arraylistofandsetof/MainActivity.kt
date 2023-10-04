package com.okanaktas.arraylistofandsetof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // <------ arrayList ----->
        var arrayList = arrayListOf<Any>("Okan",27)
        println("First element: ${arrayList[0]}")

        //<------ setOf -------->
        var setList = setOf<Any>(1,1,2,3)

        print(setList.size)

        //setList içerisindekileri lambda ile foreach kullanarak ekrana bastırma
        setList.forEach { println(it) }

        // <---- map ------->
        //key - value   

        var fruitList = hashMapOf<String,Int>()
        fruitList.put("banana",100)
        fruitList.put("apple",150)

        print(fruitList["apple"])
    }
}