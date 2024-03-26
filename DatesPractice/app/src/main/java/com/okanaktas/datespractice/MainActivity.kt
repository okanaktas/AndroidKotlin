package com.okanaktas.datespractice

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.okanaktas.datespractice.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun deneme(view: View) {
        showDateTimePicker()
    }

    private fun showDateTimePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this, { _, year, month, dayOfMonth ->
                val selectedDateTime = Calendar.getInstance()
                selectedDateTime.set(year, month, dayOfMonth)

                val hour = selectedDateTime.get(Calendar.HOUR_OF_DAY)
                val minute = selectedDateTime.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this, { _, hourOfDay, minute ->
                        selectedDateTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                        selectedDateTime.set(Calendar.MINUTE, minute)
                        val formattedDateTime = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(selectedDateTime.time)
                        binding.textView.text = formattedDateTime
                    }, hour, minute, true
                )
                timePickerDialog.show()
            }, year, month, dayOfMonth
        )
        datePickerDialog.show()
    }
}