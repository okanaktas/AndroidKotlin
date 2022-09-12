package com.okanaktas.catchcartooncharacters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import com.okanaktas.catchcartooncharacters.databinding.ActivityGameBinding
import com.okanaktas.catchcartooncharacters.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    var runnable : Runnable = Runnable {}
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Gelen degeri alma
        val intent = intent
        var deger = intent.getStringExtra("inputValue")
        binding.textViewInput.setText("Gelen deger: $deger")
        //Gelen degeri int e cevirme
        var newDeger = deger!!.toInt()
        //Runnable oluşturma
        runnable = object : Runnable{
            override fun run() {
                newDeger--
                binding.textViewInput.setText("Time: $newDeger")

                handler.postDelayed(runnable,1000)
            }
        }
        handler.post(runnable)

        

    }
}