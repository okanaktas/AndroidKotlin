package com.okanaktas.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.okanaktas.myapplication.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences("com.okanaktas.myapplication", MODE_PRIVATE)

        binding.button.setOnClickListener {
            var name = binding.editTextText.text.toString()
            var age = binding.editTextText2.text.toString().toInt()
            var job = binding.editTextText3.text.toString()



            sharedPref.edit().putString("deger", binding.editTextText.text.toString()).apply()
            var gelen = sharedPref.getString("deger","Gelmedi")

            binding.textView.setText(gelen.toString())


        }
    }
}