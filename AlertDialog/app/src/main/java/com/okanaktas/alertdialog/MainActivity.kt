package com.okanaktas.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.okanaktas.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


    fun buttonAlert(view : View){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Alert Dialog")
        alertDialog.setMessage("Choose One")
        alertDialog.setPositiveButton("Yes!"){dialog, which ->
            Toast.makeText(applicationContext,"You Say Yes!",Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton("No!"){dialog, which ->
            Toast.makeText(applicationContext,"You Say No!",Toast.LENGTH_LONG).show()
        }
        alertDialog.show()
    }
}