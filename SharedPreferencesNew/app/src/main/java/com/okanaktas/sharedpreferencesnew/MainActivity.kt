package com.okanaktas.sharedpreferencesnew

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.okanaktas.sharedpreferencesnew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //İlk kısma genelde paket ismi, ikinci kısma nasıl bir mode kullanacağımızı yazarız. Başka bir uygulamnın
        // verilerimizi kullanmasını istemediğimiz için mode_private kullanıyoruz.
        sharedPref = this.getSharedPreferences("com.okanaktas.myapplication", MODE_PRIVATE)
//veri yazacak veya güncelleyeceksek edit diyoruz. put fonksiyonları çıkıyor karşımıza orada da anahtar ve deger veriyoruz.
        // Halihazırda bir veriyi almak istiyorsak get fonksiyonlarını kullanıyoruz ve
        // kaydettiğimiz anahtarı veriyoruz o bize bir deger veriyor

//aşağıda gelen değeri alıyoruz. buttonSave de "age" dediğimiz için yine age olarak çektik. İkinci kısım ise
        //o deger gelmezse ne yazacağı
        var userAgePref = sharedPref.getInt("age", -1)
        //o değer gelmediğinde -1 olacağı için değer if kontrolü ile kullanıcıya -1 yazmasını engelliyoruz.
        if (userAgePref == -1) {
            binding.textViewAge.setText("Your Age: ")
        } else {
            binding.textViewAge.setText("Your Age: ${userAgePref}")
        }
    }

    fun buttonSave(view: View) {
        var age = binding.editTextAge.text.toString().toIntOrNull()
        if (age != null) {
            binding.textViewAge.setText("Your Age : ${age}")
            sharedPref.edit().putInt("age", age).apply()
        } else {
            binding.textViewAge.setText("Yanlış bir yerler oldu.")
        }
    }

    fun buttonDelete(view: View) {}
}