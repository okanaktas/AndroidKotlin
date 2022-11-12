package com.okanaktas.forwardcounterandreversecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.forwardcounterandreversecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val runnable : Runnable = Runnable{}
    val handler : Handler = Handler()

    var counter = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun buttonForward(view : View){
        runnable : object = 
        binding.textViewForward.setText("Forward Counter: $counter")
        counter++
    }
    fun buttonReverse(view : View){

    }
}