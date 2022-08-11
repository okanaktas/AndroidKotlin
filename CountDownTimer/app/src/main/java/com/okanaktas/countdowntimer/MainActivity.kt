package com.okanaktas.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.okanaktas.countdowntimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonCountDown.setOnClickListener{

            object : CountDownTimer(10000,1000){
                override fun onTick(timer: Long) {
                    //Her saniyede ne yapılacak
                    binding.textView.setText("Left: ${timer/1000}")
                }

                override fun onFinish() {
                    //İşlem bitince ne olacak
                    binding.textView.setText("Left: 0")
                    Toast.makeText(this@MainActivity, "Finished",Toast.LENGTH_LONG).show()

                }
            }.start()
        }


    }
}