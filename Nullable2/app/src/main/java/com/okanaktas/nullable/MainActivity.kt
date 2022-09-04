package com.okanaktas.nullable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var age: Int? = null

        // 1-null safe
        if (age != null) {
            println(age * 10)
        } else {
            println("Age is null")
        }

        // 2-safe call  - age e ? ekledik. age var mı yok mu bilmiyoruz anlamına geliyor ve şu an null döndürür ekranda
        println(age?.compareTo(2))

        // 3-elvis - yine age e ? ekliyoruz ve en son ?: yazıyoruz buradaki ?: 100 demek
        //Eğer sonuç null ise sonucu 100 e eşitle
        var myResult = age?.compareTo(2) ?: 100
        println(myResult)
    }
}