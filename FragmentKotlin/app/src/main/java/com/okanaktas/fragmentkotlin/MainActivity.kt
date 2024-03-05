package com.okanaktas.fragmentkotlin

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun button1(view: View) {
        //fragment ı kullanabilmek için fragment yönetici diye bir yapıyı çağırmamız gerekiyor
        val fragmentManager = supportFragmentManager
        //yapıcağımız işlemleri başlatmak için fragmentTransaction diye bir yapı oluşturuyoruz. bu fragmentlarla bazı değişiklikler yapacağım ben diyoruz.
        val fragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()
        //İlk containerView istiyor. Kim barındıracak kim gösterecek bunu frameLayout umuz. İkincisi hangi fragment i gösterecek onu soruyor.
        fragmentTransaction.replace(R.id.frameLayout,firstFragment).commit()
    }

    fun button2(view: View) {

        //fragment ı kullanabilmek için fragment yönetici diye bir yapıyı çağırmamız gerekiyor
        val fragmentManager = supportFragmentManager
        //yapıcağımız işlemleri başlatmak için fragmentTransaction diye bir yapı oluşturuyoruz. bu fragmentlarla bazı değişiklikler yapacağım ben diyoruz.
        val fragmentTransaction = fragmentManager.beginTransaction()

        val secondFragment = SecondFragment()
        //İlk containerView istiyor. Kim barındıracak kim gösterecek bunu frameLayout umuz. İkincisi hangi fragment i gösterecek onu soruyor.
        fragmentTransaction.replace(R.id.frameLayout,secondFragment).commit()
    }
}