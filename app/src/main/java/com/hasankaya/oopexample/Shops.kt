package com.hasankaya.oopexample

class Shops(shopName: String, shopCode: Int, mallId:Int ) {
//encapsulation örneği
    var shopName: String?= shopName
        private set //değişime izin vermiyoruz bu şekilde.
        get //verinin okunmasına izin veriyoruz.
    var shopCode: Int?= shopCode
        set
        get
    var mallId: Int?=mallId
        get
        private set

}