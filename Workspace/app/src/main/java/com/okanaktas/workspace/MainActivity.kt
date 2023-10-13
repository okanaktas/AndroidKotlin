package com.okanaktas.workspace

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.okanaktas.workspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


    }
    fun buttonGo(view : View){
        var alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Alert Title")
        alert.setMessage("Uyarı mesajı")

        alert.setPositiveButton("yes", object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Sen şimdi naneyi yemedin mi ?",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

        alert.setNegativeButton("No!",object  : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity,"No dediniz",Toast.LENGTH_LONG).show()
            }

        })
        alert.show()
    }
}