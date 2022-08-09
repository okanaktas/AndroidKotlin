package com.okanaktas.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.okanaktas.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences

    var ageFromSharedPreferences : Int? = null

    var age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.okanaktas.sharedpreferences", MODE_PRIVATE)

        //Birinci değer tanımladığımız age i çektik ageShared olan kısım.
        //İkinci kısım ageShared diye bir değer yoksa default olarak ne döndüreyim kısmı.
        ageFromSharedPreferences = sharedPreferences.getInt("ageShared", 0)

        if(ageFromSharedPreferences!! <0){
            binding.textView.setText("Age isn't negative")
        }else{
            binding.textView.setText("Your Age: ${ageFromSharedPreferences}")
        }
    }

    fun buttonSave(view: View) {

        age = binding.editTextNumber.text.toString().toIntOrNull()

        if (age != null) {
            binding.textView.setText("Your Age: ${age}")
            sharedPreferences.edit().putInt("ageShared", age!!).apply()
        } else {
            binding.textView.setText("Error. Age isn't null")
        }
    }

    fun buttonDelete(view: View) {
        ageFromSharedPreferences = sharedPreferences.getInt("ageShared", 0)

        if(ageFromSharedPreferences!!>0){
            sharedPreferences.edit().remove("ageShared").apply()
            binding.textView.setText("Your Age: ")
        }
    }
}