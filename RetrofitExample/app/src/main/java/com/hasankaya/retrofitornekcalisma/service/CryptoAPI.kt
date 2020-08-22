package com.hasankaya.retrofitornekcalisma.service

import com.hasankaya.retrofitornekcalisma.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface CryptoAPI {
    //GET, POST, UPDATE, DELETE...
    //https://api.nomics.com/v1/
    // prices?key=b682c5515a4a66a081c0e6e5ae233c18

    //Aşağıda şunu demek istedik;
    //Bana bir get işlemi yap, şu adresten
    //bu get işleminde getData diye bir fonksiyon tanımlıyorum.
    //Bu get data çağrıldığında bir Call yapılacak ve geri dönen şey bana CryptoModel olacak ve Liste halinde gelecek. (Çünkü birden fazla CryptoModel gelecek.)

    @GET("prices?key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
   // fun getData(): Call<List<CryptoModel>>

    fun getData(): Observable<List<CryptoModel>>

}