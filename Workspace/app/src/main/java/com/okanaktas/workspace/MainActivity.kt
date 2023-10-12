package com.okanaktas.workspace

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.okanaktas.workspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.workspace", MODE_PRIVATE)

        binding.textView.setText(sharedPref.getString("deger","Hatta var demektir."))


        binding.button.setOnClickListener {
            binding.textView.setText(binding.editTextText.text.toString())
            sharedPref.edit().putString("deger",binding.textView.text.toString()).apply()

            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }
}