package com.okanaktas.vehiclelogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.vehiclelogos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var vehicleArray : ArrayList<Vehicle>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var bmw = Vehicle("bmw", 1990, R.drawable.bmw)
        var mercedes = Vehicle("mercedes", 1991, R.drawable.mercedes)
        var audi = Vehicle("audi", 1992, R.drawable.audi)
        var volkwogen = Vehicle("volkwagen", 1993, R.drawable.volkwagen)

        vehicleArray = ArrayList<Vehicle>()

        vehicleArray.add(bmw)
        vehicleArray.add(mercedes)
        vehicleArray.add(audi)
        vehicleArray.add(volkwogen)


    }
}