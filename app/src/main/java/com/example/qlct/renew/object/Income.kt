package com.example.qlct.renew.`object`

class Income {
    private var _id: String?= ""
    var id
        get() = _id ?: ""
        set(value) {
            _id = value
        }
}