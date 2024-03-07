package com.okanaktas.coroutineforkotlinandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

        //Global Scope -> uygulamanın kendisinde direkt app in her yerinde çalıştırılmak üzerene açıyor coroutine i
        /* GlobalScope.launch {
             repeat(100000) {
                 launch {
                     println("Android")
                 }
             }
         }
         *//*
        println("GlobalScope Start")
        GlobalScope.launch {
            launch {
                delay(5000)
                println("Global Scope")
            }
        }
        println("GlobalScope Finish")
         */

        //runBlocking -> Bir scope oluşturuyor coroutine ler için ama bloklayarak. Öncesinde işlemleri yapıyorsunuz. İşlem işlem sonra runBlocking geliyor o bitene kadar içerisinde ki coroutine işlemleri bitene kadar sonrasındaki kodların çalışmasını durduruyor.
        /* println("run blocking start")
         runBlocking {
             launch {
                 delay(2000)
                 println("run blocking")
             }
         }
         println("run blocking end")
         */

        /*
        //En çok kullanacağımız CoroutineScope -> İçerisinde ki bütün corutine ler bitene kadar çalışmaya devam ediyor.
        //CoroutineScope
        println("Coroutine start")
        CoroutineScope(Dispatchers.Default).launch {
            launch {
                delay(5000)
                println("Coroutine Scope")
            }
        }
        println("Coroutine End")
         */


        //Dispatchers
        //Dispatchers.Default -> CPU Intensive(CPU yoğun işlemlerde) Görsel işleme, çok uzun bir diziyi alfabetik olarak dizme uzun sürecek bir işlem içinde yüz bin kelime var dizinin gibi
        //Dispatchers.IO -> Network işlemleri(internetten veri çekme, veritabanından veri çekme)
        //Dispatchers.Main -> Kullanıcının göreceği işlemleri yapmamız gereken yer. Mesela Defaultta yaptığımız işlemi burada gösterebiliriz yada internetten çektiğimiz verileri
        //Dispatchers.Unconfined -> Inherited dispatcher(Nereden çalıştırıldıysa ya da oluşturulduysa) oradan inherited(miras alıyor) ediyor. Yani içerisinde çalıştırıldığı yere göre değişiyor kendi ayarlıyor diyebiliriz.

        //Dispatchers ların hangi thread de çalıştığını görmek için. Burada Dolar işaretinden sonra Thread.currentThread demek güncel thread neyse onu al ve .name diyerek bana ismini söyle diyoruz
        runBlocking {
            launch(Dispatchers.Main) {
                println("Main Thread: ${Thread.currentThread().name}")
            }
            launch(Dispatchers.IO) {
                println("IO Thread: ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default Thread: ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Unconfined) {
                println("Unconfined Thread: ${Thread.currentThread().name}")
            }

        }
    }
}