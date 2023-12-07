package com.example.qlct.renew.`object`

class Income {
    private var _id: String? = ""
    var id
        get() = _id ?: ""
        set(value) {
            _id = value
        }

    private var _walletId: String? = ""
    var walletId
        get() = _walletId ?: ""
        set(value) {
            _walletId = value
        }

    private var _money: Int? = 0
    var money
        get() = _money ?: 0
        set(value) {
            _money = value
        }

    private var _note: String? = ""
    var note
        get() = _note ?: ""
        set(value) {
            _note = value
        }

    private var _date: String? = ""
    var date
        get() = _date ?: ""
        set(value) {
            _date = value
        }
}