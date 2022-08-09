package com.okanaktas.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var number1 : Int? = null
    var number2 : Int? = null
    var result : Int? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun buttonSum(view: View) {
        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()

        if(number1 != null && number2 !=null){
            result = number1!! + number2!!
            binding.resultText.setText("Result: ${result}")
        }
        else{
            binding.resultText.setText("Error!")
        }
    }

    fun buttonSub(view: View) {

        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()

        if(number1 != null && number2 !=null){
            result = number1!! - number2!!
            binding.resultText.setText("Result: ${result}")
        }
        else{
            binding.resultText.setText("Error!")
        }
    }

    fun buttonMultiply(view: View) {

        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()

        if(number1 != null && number2 !=null){
            result = number1!! * number2!!
            binding.resultText.setText("Result: ${result}")
        }
        else{
            binding.resultText.setText("Error!")
        }
    }

    fun buttonDiv(view: View) {

        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()

        if(number1 != null && number2 !=null){
            result = number1!! / number2!!
            binding.resultText.setText("Result: ${result}")
        }
        else{
            binding.resultText.setText("Error!")
        }
    }
}