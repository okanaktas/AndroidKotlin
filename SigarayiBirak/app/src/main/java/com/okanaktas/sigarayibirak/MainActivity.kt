package com.okanaktas.sigarayibirak

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.okanaktas.sigarayibirak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun main(view: View) {
        val intent = Intent(this@MainActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun health(view: View) {
        val intent = Intent(this@MainActivity, HealthActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun settings(view: View) {
        val intent = Intent(this@MainActivity, SettingsActivity::class.java)
        startActivity(intent)
        finish()
    }
}