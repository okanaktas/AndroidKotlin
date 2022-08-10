package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.okanaktas.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun buttonAlert(view: View) {

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Alert Message")
        alertDialog.setMessage("Select One")
        alertDialog.setPositiveButton("Yes!") { alertDialog, which ->
            Toast.makeText(applicationContext, "You say yes", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton("No") { alertDialog, which ->
            Toast.makeText(applicationContext, "You Say No", Toast.LENGTH_LONG).show()
        }
            alertDialog.show()
    }
}