package com.okanaktas.nullability

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.nullability.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //Nullability

        var deger: Int? = null

        deger = 10

        print(deger)


        //safe call
        println(deger?.minus(10))

        //if
        if (deger != null) {
            print(deger.minus(10))
        } else {
            print("my deger is null")
        }
        //koşul sağlanıyor ise 10 ile çarp fakat koşul sağlanmıyosa hiç bir şey yapma
        deger?.let {
            print(it*10)
        }

    }
}