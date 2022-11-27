 package com.okanaktas.countdowntimerforchess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.countdowntimerforchess.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

     fun buttonGo(view : View){
         val intent = Intent(applicationContext,GameActivity::class.java)
         intent.putExtra("name", binding.editTextPlayer1.text.toString())
         intent.putExtra("SurName", binding.editTextPlayer2.text.toString())
         intent.putExtra("minute", binding.editTextTimer.text.toString().toInt())
         startActivity(intent)
     }
}