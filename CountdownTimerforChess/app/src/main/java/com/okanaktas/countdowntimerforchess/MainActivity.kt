package com.okanaktas.countdowntimerforchess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.okanaktas.countdowntimerforchess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun buttonGo(view: View) {
        if (binding.editTextPlayer1.text.isEmpty() || binding.editTextPlayer2.text.isEmpty() || binding.editTextTimer.text.isEmpty()) {
            Toast.makeText(applicationContext, "Cannot be blank!", Toast.LENGTH_LONG).show()
        } else {

            val intent = Intent(applicationContext, GameActivity::class.java)
            intent.putExtra("player1", binding.editTextPlayer1.text.toString())
            intent.putExtra("player2", binding.editTextPlayer2.text.toString())
            intent.putExtra("minute", binding.editTextTimer.text.toString())
            startActivity(intent)
        }

    }
}