package com.okanaktas.workshop
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var userChoiceText: TextView
    private lateinit var computerChoiceText: TextView
    private lateinit var resultText: TextView
    private lateinit var rockButton: Button
    private lateinit var paperButton: Button
    private lateinit var scissorsButton: Button
    private lateinit var computerImageView: ImageView
    private val choices = arrayOf("Taş", "Kağıt", "Makas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userChoiceText = findViewById(R.id.userChoiceText)
        computerChoiceText = findViewById(R.id.computerChoiceText)
        resultText = findViewById(R.id.resultText)
        rockButton = findViewById(R.id.rockButton)
        paperButton = findViewById(R.id.paperButton)
        scissorsButton = findViewById(R.id.scissorsButton)
        computerImageView = findViewById(R.id.computerImageView)

        rockButton.setOnClickListener {
            playGame("Taş")
        }

        paperButton.setOnClickListener {
            playGame("Kağıt")
        }

        scissorsButton.setOnClickListener {
            playGame("Makas")
        }
    }

    private fun playGame(userChoice: String) {
        val computerChoice = getRandomChoice()
        displayChoices(userChoice, computerChoice)

        val result = determineWinner(userChoice, computerChoice)
        displayResult(result)
    }

    private fun getRandomChoice(): String {
        val randomIndex = Random().nextInt(choices.size)
        return choices[randomIndex]
    }

    private fun displayChoices(userChoice: String, computerChoice: String) {
        userChoiceText.text = "Senin Seçimin: $userChoice"
        computerChoiceText.text = "Bilgisayarın Seçimi: $computerChoice"
    }

    private fun determineWinner(userChoice: String, computerChoice: String): String {
        return when {
            userChoice == computerChoice -> "Berabere!"
            (userChoice == "Taş" && computerChoice == "Makas") ||
                    (userChoice == "Kağıt" && computerChoice == "Taş") ||
                    (userChoice == "Makas" && computerChoice == "Kağıt") ->
                "Kazandın!"
            else -> "Kaybettin!"
        }
    }

    private fun displayResult(result: String) {
        resultText.text = result
    }
}
