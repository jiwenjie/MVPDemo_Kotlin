package com.example.root.mvpdemo_kotlin.contract

import android.view.View
import com.example.root.mvpdemo_kotlin.base.BasePresenter
import com.example.root.mvpdemo_kotlin.base.BaseView
import com.example.root.mvpdemo_kotlin.entity.Book

/**
 *   author:Jiwenjie
 *   email:Jiwenjie97@gmail.com
 *   time:2018/10/20
 *   desc: 契约类，里面放 Presenter 和 View
 *   version:1.0
 */
interface BookContract {

    interface BookView : BaseView {
        fun setData(beans: Book)
    }

    interface Presenter: BasePresenter {
        fun attachView(view: BookContract.BookView)
        fun requestData()
    }

}











