package com.okanaktas.workspace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.okanaktas.workspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


    }

    fun buttonSend(view: View) {
        var intent = Intent(this@MainActivity,MainActivity2::class.java)
        intent.putExtra("name",binding.editTextName.text.toString())
        if(binding.editTextPassword.text.toString().toInt()<0 || binding.editTextPassword.text.toString().isNotEmpty()){
            Toast.makeText(this@MainActivity,"Sıfırdan küçük olamaz",Toast.LENGTH_LONG).show()
        }
        else{
            intent.putExtra("password",binding.editTextPassword.text.toString())
        }
        startActivity(intent)
    }
}