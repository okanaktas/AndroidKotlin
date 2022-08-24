package com.okanaktas.workstation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.okanaktas.workstation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    
    fun buttonLogin(view: View){
        if( binding.nameText.text.equals("okan") && binding.passwordText.text.equals("123123")){
            Toast.makeText(applicationContext,"True infromation!",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(applicationContext,"Wrong infromation",Toast.LENGTH_LONG).show()
        }

    }

}