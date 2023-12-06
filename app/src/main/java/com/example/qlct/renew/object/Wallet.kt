package com.example.qlct.renew.`object`

class Wallet {
    private var _id: String?= ""
    var id
        get() = _id ?: ""
        set(value) {
            _id = value
        }


    private var _moneyAmount: Long?= 0
    var moneyAmount
        get() = _moneyAmount ?: 0
        set(value) {
            _moneyAmount = value
        }
}