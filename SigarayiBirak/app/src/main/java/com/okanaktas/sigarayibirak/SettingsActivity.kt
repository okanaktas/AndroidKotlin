package com.okanaktas.sigarayibirak

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.okanaktas.sigarayibirak.databinding.ActivitySettingsBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    lateinit var sharedPref: SharedPreferences

    private var cal: Calendar = Calendar.getInstance()

    private var selectedDate: Calendar? = null


    private var hour: Int? = null
    private var minute: Int? = null
    private var second: Int? = null
    private var miliSecond: Int? = null

    private var year: Int? = null
    private var month: Int? = null
    private var dayOfMonth: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.okanaktas.sigarayibirak", MODE_PRIVATE)

        hour = cal.get(Calendar.HOUR_OF_DAY)
        minute = cal.get(Calendar.MINUTE)
        second = cal.get(Calendar.SECOND)
        miliSecond = cal.get(Calendar.MILLISECOND)

        println("Şu an saat: ${hour}, Dakika: ${minute}, Saniye:${second}, MilisSaniye: ${miliSecond}")

        year = cal.get(Calendar.YEAR)
        month = cal.get(Calendar.MONTH) + 1
        dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)

        println("Şu an ki sene: ${year} , ay ${month} , gün ${dayOfMonth}")

    }

    fun buttonReset(view: View) {

        val snackbar = Snackbar.make(view, "Bırakma Tarihi Sıfırlanacak Emin Misiniz ?", Snackbar.LENGTH_INDEFINITE).setAction("Evet") {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            val currentDateTimeString = dateFormat.format(cal.time)

            binding.textViewDateInfo.text = currentDateTimeString
        }.setActionTextColor(resources.getColor(android.R.color.holo_green_dark)) // Evet butonunun rengini ayarla

        snackbar.addCallback(object : Snackbar.Callback() {
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                if (event == DISMISS_EVENT_TIMEOUT || event == DISMISS_EVENT_SWIPE) {
                    // Snackbar zaman aşımı veya kaydırma ile kapatıldığında yapılacak işlemler
                    // Örneğin:
                    // işlemiIptalEt()
                }
            }
        })

        // Snackbar'ı göster
        snackbar.show()
    }

    fun selectDate(view: View) {
        showDateTimePickerDialog()

    }

    private fun showDateTimePickerDialog() {

        val datePickerDialog = year?.let {
            month?.let { it1 ->
                dayOfMonth?.let { it2 ->
                    DatePickerDialog(
                        this, { _, year, month, dayOfMonth ->
                            val selectedDateTime = Calendar.getInstance()
                            selectedDateTime.set(year, month, dayOfMonth)
                            hour?.let {
                                minute?.let { it1 ->
                                    TimePickerDialog(
                                        this, { _, hourOfDay, minute ->
                                            selectedDateTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                                            selectedDateTime.set(Calendar.MINUTE, minute)
                                            val formattedDateTime = android.text.format.DateFormat.format("dd/MM/yyyy HH:mm", selectedDateTime.time)
                                            binding.textViewDateInfo.text = formattedDateTime
                                        }, it, it1, true
                                    ).show()
                                }
                            }
                        }, it, it1, it2
                    )
                }
            }
        }

        datePickerDialog!!.datePicker.maxDate = System.currentTimeMillis() // İleri bir tarih seçimini engelle
        datePickerDialog.show()
    }

    fun buttonSave(view: View) {

    }

    fun main(view: View) {
        val intent = Intent(this@SettingsActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun health(view: View) {
        val intent = Intent(this@SettingsActivity, HealthActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun settings(view: View) {
        val intent = Intent(this@SettingsActivity, SettingsActivity::class.java)
        startActivity(intent)
        finish()
    }
}