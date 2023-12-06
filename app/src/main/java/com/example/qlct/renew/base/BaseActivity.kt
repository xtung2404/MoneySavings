package com.example.qlct.renew.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB: ViewDataBinding>: AppCompatActivity() {
    protected lateinit var binding: VB
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        setContentView(binding.root)
        initView()
        initAction()
    }

    open fun initView() {}

    open fun initAction() {}

}