package com.okanaktas.landmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.okanaktas.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var landMarkArrayList: ArrayList<LandMark>

    var number : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //data
        val colosseum = LandMark("Colosseum", "Italy", R.drawable.colosseum)
        val eiffel = LandMark("Eiffel", "France", R.drawable.eiffel)
        val london_bridge = LandMark("London Bridge", "England", R.drawable.london_bridge)
        val pisa = LandMark("Pisa", "Italy", R.drawable.pisa)
        

        landMarkArrayList = ArrayList<LandMark>()

        landMarkArrayList.add(colosseum)
        landMarkArrayList.add(eiffel)
        landMarkArrayList.add(london_bridge)
        landMarkArrayList.add(pisa)

        //RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = LandmarkAdapter(landMarkArrayList)
        binding.recyclerView.adapter = adapter

        //adapter :  layout & data

        //mapping -> bir veriyi başka bir veriye benzetmeye veya değiştirmeye yarar.

        /* listView

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landMarkArrayList.map { LandMark -> LandMark.name })
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(MainActivity@this, DetailsActivity::class.java)
            intent.putExtra("landMark",landMarkArrayList.get(i))
            startActivity(intent)
        }

        */
    }
}