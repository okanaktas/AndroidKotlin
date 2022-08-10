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

        Toast.makeText(applicationContext, "Welcome to app", Toast.LENGTH_LONG).show()
    }

    fun buttonSave(view: View) {

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Save")
        alertDialog.setMessage("Are You Sure")
        alertDialog.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG)
        }
        alertDialog.setNegativeButton("No") { dialog, which ->
            Toast.makeText(this, "Not Saved", Toast.LENGTH_LONG)
        }.show()
    }
}