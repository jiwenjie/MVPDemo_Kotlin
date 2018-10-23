package com.example.root.mvpdemo_kotlin.presenter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.root.mvpdemo_kotlin.contract.BookContract
import com.example.root.mvpdemo_kotlin.entity.Book
import com.example.root.mvpdemo_kotlin.model.DataModel
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 *   author:Jiwenjie
 *   email:Jiwenjie97@gmail.com
 *   time:2018/10/20
 *   desc:
 *   version:1.0
 */
class BookPresenter(context: Context, view: BookContract.BookView) : BookContract.Presenter {

    var mContext: Context? = null
    var mView: BookContract.BookView? = null
    val model: DataModel by lazy {
        DataModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable: Observable<Book>? = mContext?.let {
            model.getBookData(mContext!!, "金瓶梅", null!!, 0, 1)
        }

    }

    override fun attachView(view: BookContract.BookView) {
        mView = view
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}











