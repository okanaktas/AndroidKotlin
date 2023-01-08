package com.okanaktas.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.guessthenumber.databinding.ActivityGameBinding
import com.okanaktas.guessthenumber.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    var runnable: Runnable = Runnable {}
    var handler: Handler = Handler()

    var timer = 61

    var number = 0

    var inputEasy = 0
    var inputMedium = 0
    var inputHard = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        inputEasy = intent.getIntExtra("valueEasy", 0)
        //inputMedium = intent.getIntExtra("valueMedium", 0)
        //inputHard = intent.getIntExtra("valueHard", 0)

        if (timer > 0) {
            runnable = object : Runnable {
                override fun run() {
                    timer--
                    binding.textViewTimer.setText("Timer: $timer")
                    handler.postDelayed(runnable, 1000)
                }
            }
            handler.post(runnable)
        } else {
            binding.textViewInfo.setText("Süre Bitti! ")
            binding.buttonSend.isEnabled = false
        }
    }

    fun buttonSend(view: View) {
        number = Integer.parseInt(binding.editTextNumber.text.toString())
        System.out.println(number)
        if (number == inputEasy) {
            binding.textViewInfo.setText("Tebrikler")
        } else {
            binding.editTextNumber.setText("")
            handler.removeCallbacks(runnable)
        }

    }
}