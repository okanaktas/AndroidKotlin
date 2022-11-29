package com.okanaktas.artbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.okanaktas.artbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    //Baglama işlemi
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflater --> XML ile kodu birbirine bağlarken kullanıyoruz

        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.art_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }
    //Menuye tiklanirsa ne yapilacagi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.add_art_item){
            val intent = Intent(this@MainActivity,ArtActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}