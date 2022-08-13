package com.okanaktas.lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun printString(myString: String){
            println(myString)
        }
        printString("merhaba")

        //lambda gösterimi

        val testPass = {myString : String -> println(myString) }
        testPass("merhaba Lambda")


        val multiply = {a:Int , b: Int -> a*b}
        println(multiply(5,4))

        //Gösterim 2
        val multiply2 : (Int, Int)-> Int = {a,b -> a*b}
        println(multiply2(5,5 ))

    }
}