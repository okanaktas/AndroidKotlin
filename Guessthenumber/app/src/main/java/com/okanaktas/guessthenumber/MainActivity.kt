package com.okanaktas.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.guessthenumber.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val random = Random()
    var numberEasy = random.nextInt(10)
    var numberMedium = random.nextInt(50)
    var numberHard = random.nextInt(100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun buttonEasy(view: View) {
       var intent = Intent(applicationContext,GameActivity::class.java)
        intent.putExtra("valueEasy", numberEasy)
        startActivity(intent)
    }
    fun buttonMedium(view: View) {
        var intent = Intent(applicationContext,GameActivity::class.java)
        intent.putExtra("valueMedium", numberMedium)
        startActivity(intent)
    }
    fun buttonHard(view: View) {
        var intent = Intent(applicationContext,GameActivity::class.java)
        intent.putExtra("valueHard", numberHard)
        startActivity(intent)
    }
}