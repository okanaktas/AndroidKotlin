package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var age : Int? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun buttonSave(view: View){
      age =  binding.editTextNumber.text.toString().toIntOrNull()
        if(age !=null){
            binding.textView.setText("Your Age: ${age}" )
        }else{
            binding.textView.setText("Error")
        }
    }
    fun buttonDelete(view: View){

    }

}