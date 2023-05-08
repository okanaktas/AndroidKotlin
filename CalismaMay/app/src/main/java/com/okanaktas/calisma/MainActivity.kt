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

        println("Dizi degerleri ${arrayOkan }")

        //setOf = aynı degerleri sadece bir kere alıyor.
        val mySet = setOf<Any>(1,2,3,3,4)
        print(mySet.size)

        //For Each

        mySet.forEach { print(it) }


        //!! Önemli HashMap

        val fruits = arrayOf<String>("Apple","Banana")
        val calories = arrayOf<Int>(100,150)

        println("${fruits[0]} + ${calories[0]}")

        //Üsttekilerin yerine

        val fruitsAndCalories = hashMapOf<String,Int>()
        fruitsAndCalories.put("Apple",100)
        fruitsAndCalories.put("Banana",150)

        println(fruitsAndCalories["Apple"])



    }
}