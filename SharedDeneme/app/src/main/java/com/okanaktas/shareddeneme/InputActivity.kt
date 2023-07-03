package com.okanaktas.shareddeneme

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


    }

    fun button(view: View) {
        var deger = binding.textView.setText(binding.editTextText.text)
        sharedPref.edit().putString("deger",deger.toString()).apply()

    }
}