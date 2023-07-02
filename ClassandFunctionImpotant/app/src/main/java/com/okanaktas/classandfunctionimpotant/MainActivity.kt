package com.okanaktas.classandfunctionimpotant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.classandfunctionimpotant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun buttonMake(view: View) {
        val name = binding.editTextText.text.toString()
        val age = binding.editTextText2.text.toString().toIntOrNull()
        val job = binding.editTextText3.text.toString()

        if (age != null) {
            val person = Person(name, age, job)

            binding.textView.text = "Name: ${person.name} age: ${person.age} job: ${person.job}"
        } else {
            binding.textView.setText("Enter age!")
        }

    }
}