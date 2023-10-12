package com.okanaktas.workspace

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.workspace.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.workspace", MODE_PRIVATE)

        var gelmisDeger = sharedPref.getString("deger","Deger Gelmedi")

        binding.textViewGelen.setText(gelmisDeger.toString())

        binding.button2.setOnClickListener {
            sharedPref.edit().putString("deger",gelmisDeger.toString()).apply()

            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}