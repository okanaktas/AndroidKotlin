package com.okanaktas.sigarayibirak

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.okanaktas.sigarayibirak.databinding.ActivityHealthBinding

class HealthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHealthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun main(view : View){
        val intent = Intent(this@HealthActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun health(view: View) {
        val intent = Intent(this@HealthActivity, HealthActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun settings(view: View) {
        val intent = Intent(this@HealthActivity, SettingsActivity::class.java)
        startActivity(intent)
        finish()
    }
}