package com.okanaktas.context

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.okanaktas.context.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 1)Toast 2)Alert Dialog 3)SnackBar

        //Context
        //Activity Context --> this
        //Application Context --> applicationContext

        Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_LONG).show()

    }

    fun buttonSave(view: View) {
        //AlertDialog
        var alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Header")
        alertDialog.setMessage("Message")
        alertDialog.setPositiveButton("Yes!", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity, "Saved!", Toast.LENGTH_LONG).show()
            }
        })
        alertDialog.setNegativeButton("No!") { p0, p1 ->
            Toast.makeText(this@MainActivity,"Not Saved!",Toast.LENGTH_LONG).show()
        }
        alertDialog.show()
    }
}
