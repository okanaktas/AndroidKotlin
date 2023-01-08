package com.okanaktas.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.guessthenumber.databinding.ActivityGameBinding
import com.okanaktas.guessthenumber.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler()

    var timer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        

    }



    fun buttonSend(view : View){

    }
}