package com.hasankaya.oopexample
//biz sınıfların başına open yazmazsak, default olarak final tipinde tanımlanır ve başka yerde kullandırmaz.
//eğer open yazarsak inheritance alabiliriz .
open class Shops(shopName: String, shopCode: Int, mallId:Int ) {
//encapsulation örneği
    var shopName: String?= shopName
        set
        get
    var shopCode: Int?= shopCode
        set
        get
    var mallId: Int?=mallId
        get//verinin okunmasına izin veriyoruz.(encapsulation)
        private set//değişime izin vermiyoruz bu şekilde.(encapsulation)

    private val softwareType: String="Enterprice"

    fun returnSoftwareType(password: String):String{
        if(password=="hasan"){
            return softwareType;
        }else{
            return "wrong pass!"
        }
    }



}