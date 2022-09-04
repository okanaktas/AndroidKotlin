package com.okanaktas.functionandclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(mySum(1,2))
        println(myMultiply(5,6))


        val sinif = Person("okan","aktas",26)
        println(sinif.name)
        println(sinif.surName)
        println(sinif.age)
    }

    //Geri unit yani java'daki void, boş değer döndürür
    fun mySum(number1 : Int , number2 : Int){
        println("Result: ${number1 + number2}")
    }

    //Geriye bir int deger döndürecek demek. Bu sayede çıkan sonucu başka bir değişkene atayabiliriz.
    fun myMultiply(a : Int, b: Int) : Int{
        return a + b
    }
}