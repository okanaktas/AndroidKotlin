package com.okanaktas.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var job: EditText
    lateinit var button: Button
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        name = findViewById(R.id.editTextText)
        age = findViewById(R.id.editTextText2)
        job = findViewById(R.id.editTextText3)
        button = findViewById(R.id.button)

        var okan = Aktas("Okan", 27, "Engineer")

        button.setOnClickListener {
            text.setText("İsminiz: ${okan.name}, Yaşınız: ${okan.age}, Mesleğiniz: ${okan.job}")
        }


    }
}