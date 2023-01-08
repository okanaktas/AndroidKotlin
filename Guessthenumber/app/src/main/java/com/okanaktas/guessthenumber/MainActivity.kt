package com.okanaktas.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.guessthenumber.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val random = Random()
        val numberEasy = random.nextInt(10)
        val numberMedium = random.nextInt(50)
        val numberHard = random.nextInt(100)
    }

    fun buttonEasy(view: View) {
       var intent = Intent(applicationContext,GameActivity::class.java)
        startActivity(intent)
    }
    fun buttonMedium(view: View) {
        var intent = Intent(applicationContext,GameActivity::class.java)
        startActivity(intent)
    }
    fun buttonHard(view: View) {
        var intent = Intent(applicationContext,GameActivity::class.java)
        startActivity(intent)
    }
}