package com.hasankaya.retrofitornekcalisma.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    //@SerializedName("currency")//bir tane değer gelecek, parametresi currency olacak demek onu al burada tanımladığım currency değişkenine ata. isimlendirilmiş parametre gibi.
    val currency:String, //!!eğer serializedname ile aynı isimleri verirsek, serializednamelere gerek kalmaz!!
    //@SerializedName("price")
    val price: String
)