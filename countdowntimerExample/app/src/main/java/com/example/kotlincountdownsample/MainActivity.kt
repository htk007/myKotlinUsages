package com.example.kotlincountdownsample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var eetStartTime: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       eetStartTime = findViewById(R.id.etStartTime) as EditText
    }

    fun startTimer(view: View){
        //geriye sayan sayaç.
        //içerisinde bizim belirleyeceğimiz bir periyoyotta, mesela bir saniyede bir,
        // yapılacak işlemleri ve ondan sonrada bu işlem bittikten sonra da ne olacağını belirten obje oluşturuyor.
        //myTimer, countdowntimer'in özelliklerini kullanan bir nesnedir.
       var startTime = eetStartTime?.text.toString()
        object: CountDownTimer((startTime.toLong()+1)*1000,1000){
            override fun onFinish() {
                tvDisplaySeconds.text="DONE!"
            }

            override fun onTick(millisUntilFinished: Long) {
                tvDisplaySeconds.text="${millisUntilFinished/1000}"
            }

        }.start()
    }
}