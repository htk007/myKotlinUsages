package com.hasankaya.oopexample

class Dog: Animal() {
    fun test(){
        super.breathe()
        //miras aldığımız sınıftaki fonksiyonu çalıştırır.
    }

    override fun breathe(){
        println("dog breathe")
    }
}