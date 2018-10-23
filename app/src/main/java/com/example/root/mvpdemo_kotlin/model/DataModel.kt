package com.example.root.mvpdemo_kotlin.model

import android.content.Context
import com.example.root.mvpdemo_kotlin.entity.Book
import com.example.root.mvpdemo_kotlin.utils.ApiService
import com.example.root.mvpdemo_kotlin.utils.RetrofitHelper
import rx.Observable

/**
 *   author:Jiwenjie
 *   email:Jiwenjie97@gmail.com
 *   time:2018/10/20
 *   desc: Model, MVP 中实际处理数据的部分
 *   version:1.0
 */
class DataModel {

    fun getBookData(context: Context, name: String, tag: String, start: Int, count: Int): Observable<Book> {
        return RetrofitHelper.getInstance(context, "https://api.douban.com/v2/")
            .create(ApiService::class.java)!!
            .getSearchBooks(name, tag, start, count)
    }

}










