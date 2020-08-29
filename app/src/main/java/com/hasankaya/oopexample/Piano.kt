package com.hasankaya.oopexample

class Piano: HouseDecor, Instrument {
    override var roomName: String
        get() = "kitchen"
        set(value) {}

    override fun info() {
        TODO("Not yet implemented")
    }
}