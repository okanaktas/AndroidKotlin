package com.okanaktas.catchcartooncharacters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.okanaktas.catchcartooncharacters.databinding.ActivityGameBinding
import com.okanaktas.catchcartooncharacters.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    var runnable: Runnable = Runnable {}
    var runnableImage: Runnable = Runnable {}

    var handler: Handler = Handler()
    var handlerImage: Handler = Handler()

    var score: Int = 0

    val imageArray = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)

        hideImages()

        //Gelen degeri alma
        val intent = intent
        var deger = intent.getStringExtra("inputValue")
        //Gelen degeri int e cevirme
        var newDeger = deger!!.toInt()

        //Gelen ismi alma
        var inputName = intent.getStringExtra("name")
        binding.textViewPlayerName.setText("Player: $inputName")

        //Runnable oluşturma
        runnable = object : Runnable {
            override fun run() {
                newDeger--
                binding.textViewInputTime.setText("Seconds: $newDeger")

                handler.postDelayed(runnable, 1000)

                if (newDeger < 0) {
                    handler.removeCallbacks(runnable)

                    handlerImage.removeCallbacks(runnableImage)
                    for(i in imageArray){
                        i.visibility = View.INVISIBLE
                    }

                    binding.textViewInputTime.setText("Seconds: Finished!!")

                    val alertDialog = AlertDialog.Builder(this@GameActivity)
                    alertDialog.setTitle("Finished Game!!")
                    alertDialog.setMessage("Your Score: $score\n\nPlay Again ?")
                    alertDialog.setPositiveButton("Yes!") { dialog, which ->
                        //Restart
                        val intent = intent
                        finish()
                        startActivity(intent)
                    }
                    alertDialog.setNegativeButton("No") { alertDialog, which ->
                        val intent = Intent(this@GameActivity, MainActivity::class.java)
                        startActivity(intent)

                        Toast.makeText(applicationContext, "Good Bye!", Toast.LENGTH_LONG).show()
                    }
                    alertDialog.show()
                }
            }
        }
        handler.post(runnable)


    }

    fun increaseScore(view: View) {
        score++
        binding.textViewScore.setText("Score: $score")
    }

    fun hideImages() {

        runnableImage = object : Runnable {
            override fun run() {

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val randomNumber = random.nextInt(9)
                imageArray[randomNumber].visibility = View.VISIBLE

                handlerImage.postDelayed(runnableImage, 550)
            }

        }
        handlerImage.post(runnableImage)
    }
}