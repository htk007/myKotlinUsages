package com.hekasoftdesign.framesexample.fragmentarasigecisornek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hekasoftdesign.framesexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toFirstOnClick(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment =
            BlankFragment()
        fragmentTransaction.replace(R.id.frameLayout,firstFragment).commit()
    }
    fun toSecondOnClick(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val secondFragment =
            BlankFragment2()
        fragmentTransaction.replace(R.id.frameLayout,secondFragment).commit()
    }
}