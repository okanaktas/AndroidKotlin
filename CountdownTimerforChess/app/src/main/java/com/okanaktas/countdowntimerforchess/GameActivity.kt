package com.okanaktas.countdowntimerforchess

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.countdowntimerforchess.databinding.ActivityGameBinding
import com.okanaktas.countdowntimerforchess.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    var runnable1: Runnable = Runnable {}
    var runnable2: Runnable = Runnable {}
    var handler1: Handler = Handler()
    var handler2: Handler = Handler()

    var timer1 = 0
    var timer2 = 0

    var minute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val inputPlayer1 = intent.getStringExtra("player1")
        val inputPlayer2 = intent.getStringExtra("player2")
        val inputMinute = intent.getStringExtra("minute").toString().toInt()

        minute = inputMinute

        timer1 = minute * 60
        timer2 = minute * 60

        binding.textViewNamePlayer1.setText("$inputPlayer1")
        binding.textViewNamePlayer2.setText("$inputPlayer2")
        binding.textViewPlayer1Time.setText("$timer1")
        binding.textViewPlayer2Time.setText("$timer2")

        binding.imageViewPlay.isEnabled=false

    }

    fun textView1(view: View) {
        binding.textViewPlayer2Time.isEnabled = true
        runnable2 = object : Runnable {
            override fun run() {
                binding.textViewPlayer2Time.setText("$timer2")
                timer2--
                handler2.postDelayed(runnable2, 1000)
            }
        }
        handler2.post(runnable2)
        binding.textViewPlayer1Time.isEnabled = false
        handler1.removeCallbacks(runnable1)

    }

    fun textView2(view: View) {
        binding.textViewPlayer1Time.isEnabled = true
        runnable1 = object : Runnable {
            override fun run() {
                binding.textViewPlayer1Time.setText("$timer1")
                timer1--
                handler1.postDelayed(runnable1, 1000)
            }
        }
        handler1.post(runnable1)
        binding.textViewPlayer2Time.isEnabled = false
        handler2.removeCallbacks(runnable2)

    }

    fun imageViewHome(view: View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    fun imageViewReset(view: View) {
        handler1.removeCallbacks(runnable1)
        handler2.removeCallbacks(runnable2)

        timer1 = minute * 60
        timer2 = minute * 60

        binding.textViewPlayer1Time.setText("${minute*60}")
        binding.textViewPlayer2Time.setText("${minute*60}")
    }
    fun imageViewPause(view: View) {
        handler1.removeCallbacks(runnable1)
        handler2.removeCallbacks(runnable2)
        binding.imageViewPlay.isEnabled = true
    }

    fun imageViewPlay(view: View) {
        handler1.post(runnable1)
        handler2.post(runnable2)
    }
}