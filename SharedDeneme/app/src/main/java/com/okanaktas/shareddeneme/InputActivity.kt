package com.okanaktas.shareddeneme

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.shareddeneme.databinding.ActivityInputBinding
import com.okanaktas.shareddeneme.databinding.ActivityMainBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.shareddeneme", MODE_PRIVATE)

    }

    fun button(view: View) {
        sharedPref.edit().putString("deger",binding.editTextText.text.toString()).apply()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}