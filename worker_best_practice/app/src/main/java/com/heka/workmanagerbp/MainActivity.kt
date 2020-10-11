package com.heka.workmanagerbp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data.Builder().putInt("intKey",1).build()

            //Burada yapılacağı koşulları belirttik. Telefon internete bağlı olmalı, aynı zamanda şarja takılı olmamalı
         val constraints = Constraints.Builder()
             .setRequiredNetworkType(NetworkType.CONNECTED)
             .setRequiresCharging(false)
             .build()
/*
        val myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
//            .setInitialDelay(5,TimeUnit.SECONDS)
//            .addTag("Tek sefer çalışacak")
            .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)
 */

        val myWorkRequest :PeriodicWorkRequest = PeriodicWorkRequestBuilder<RefreshDatabase>(15,TimeUnit.MINUTES)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)
        //durumu kontrol etmek için;
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWorkRequest.id).observe(this,
            Observer {
                if(it.state == WorkInfo.State.RUNNING){
                    println("running")
                }else if(it.state == WorkInfo.State.FAILED){
                    println("failed")
                }
            })

        //iptal etmek istersek;
        //WorkManager.getInstance(this).cancelAllWork()
/*
        //Chaining
        //bir defa çağıralacak requestlerde kullanırız. planlamaya yarar.
        val myOneTimeRequest : OneTimeWorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()
        //Hangisi hangisinden sonra çalışacak (zincirleme) burada planlayabiliriz.
        WorkManager.getInstance(this).beginWith(myOneTimeRequest)
            .then(myOneTimeRequest)
            .then(myOneTimeRequest)
            .enqueue()*/

    }
}