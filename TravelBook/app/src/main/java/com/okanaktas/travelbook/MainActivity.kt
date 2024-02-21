package com.okanaktas.travelbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.okanaktas.travelbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




    }

    //olusturdugumuz menuyu ana aktivitemiz ile bagladımızı kısım
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //ne zaman bir xml ile kodu baglacayacagız inflater ile calisiyoruz
        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.place_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //o menuden herhangi bir eleman secilirse ne olacıgını yazdıgımız kısım
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //su an menu icerisinde bir tane item var yine de kontrol ediyoruz hangi item seciliyor diye
        if(item.itemId == R.id.add_place){
            val intent = Intent(this@MainActivity,MapsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}