package com.okanaktas.workmanager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

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

        val data = Data.Builder().putInt("intKey", 1).build()

        val constraints = Constraints.Builder().setRequiresCharging(false).build()

        /*
        val myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)//build yapmadana önce istediğim constrainskeri ekledim
            .setInputData(data)//benim verim var mı ? var. Bunları gönder birlikte
            //.setInitialDelay(5,TimeUnit.HOURS)//bunu gecikmeli başlat.
            //.addTag("myTag")//etiket eklemek istersek
            .build()

        //calıştırmak için workmanagerın kendisini çağırıyorum
        WorkManager.getInstance(this).enqueue(myWorkRequest)

         */

        //periodic oldugu zaman constructer vermemiz gerek
        //Android en az 15 dakika ara ile bunu yapılabilmesine izin veriyor daha az olmuyor
        val myWorkRequest: PeriodicWorkRequest = PeriodicWorkRequestBuilder<RefreshDatabase>(15, TimeUnit.MINUTES).setConstraints(constraints).setInputData(data).build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)

        //Durumunu sorgulamak için
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWorkRequest.id).observe(this, Observer {
            if (it.state == WorkInfo.State.RUNNING) {
                println("running")
            } else if (it.state == WorkInfo.State.FAILED) {
                println("failed")
            } else if (it.state == WorkInfo.State.SUCCEEDED) {
                println("succeeded")
            }
        })

        /*
        //iptal etmek istiyoruz diyelim.
        WorkManager.getInstance(this).cancelAllWork()

        //Chaining

        //arka arkaya zincirleme ve bunları bağlama, sen şu işlemle başla o bitsin bunu yap falan fakat bu sadece OneTimeRequest ile çalışıyor.
        val oneTimeRequest : OneTimeWorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        WorkManager.getInstance(this).beginWith(oneTimeRequest)
            .then(oneTimeRequest)
            .then(oneTimeRequest)
            .enqueue()

         */
    }
}