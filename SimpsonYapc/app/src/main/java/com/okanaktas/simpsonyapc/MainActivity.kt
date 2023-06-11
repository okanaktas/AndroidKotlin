package com.okanaktas.simpsonyapc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.simpsonyapc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun buttonSave(view: View) {
        val name = binding.editTextName.text.toString()
        val age = binding.editTextAge.text.toString().toInt()
        val job = binding.editTextJob.text.toString()

        if (age != null) {
            val simpson = Simpson(name, age, job)
            binding.textViewResult.setText("Name: ${simpson.name} Age: ${simpson.age} Job: ${simpson.job}")
        } else {
            binding.textViewResult.setText("Enter your age!")
        }
    }
}