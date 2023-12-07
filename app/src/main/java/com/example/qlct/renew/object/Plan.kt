package com.example.qlct.renew.`object`

class Plan {
    private var _id: String?= ""
    var id
        get() = _id ?: ""
        set(value) {
            _id = value
        }

    private var _name: String?= ""
    var name
        get() = _name ?: ""
        set(value) {
            _name = value
        }

    private var _customerId: String?= ""
    var customerId
        get() = _customerId ?: ""
        set(value) {
            _customerId = value
        }

    private var _finish: Boolean?= false
    var finish
        get() = _finish?: false
        set(value) {
            _finish = value
        }

    private var _note: String?= ""
    var note
        get() = _note?: ""
        set(value) {
            _note = value
        }

    private var _money: Int?= 0
    var money
        get() = _money?: 0
        set(value) {
            _money = value
        }

    private var _dateStart: String?= ""
    var dateStart
        get() = _dateStart?: ""
        set(value) {
            _dateStart = value
        }

    private var _dateEnd: String?= ""
    var dateEnd
        get() = _dateEnd?: ""
        set(value) {
            _dateEnd = value
        }
}