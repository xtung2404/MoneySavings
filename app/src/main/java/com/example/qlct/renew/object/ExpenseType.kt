package com.example.qlct.renew.`object`

class ExpenseType {
    private var _id: String?= ""
    var id
        get() = _id ?: ""
        set(value) {
            _id = value
        }

    private var _expenseName: String?= ""
    var expenseName
        get() = _expenseName ?: ""
        set(value) {
            _expenseName = value
        }
}