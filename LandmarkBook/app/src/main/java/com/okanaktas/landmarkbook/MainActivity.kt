package com.okanaktas.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.okanaktas.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.colosseum)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eiffel)
        val london_bridge = Landmark("London Bridge", "UK", R.drawable.london_bridge)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(london_bridge)

        binding.recylerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdaptor = LandmarkAdaptor(landmarkList)
        binding.recylerView.adapter = landmarkAdaptor


    }
}