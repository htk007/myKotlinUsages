package com.hasankaya.oopexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var shopOne= Shops("Adidas",2000601,7);
        println("(1): \n"+shopOne.shopName + "\n" +shopOne.shopCode.toString() + "\n"+ shopOne.mallId.toString())
      shopOne.shopCode=2000602
        println("(2): \n"+shopOne.shopName + "\n" +shopOne.shopCode.toString() + "\n"+ shopOne.mallId.toString())
        


    }
}