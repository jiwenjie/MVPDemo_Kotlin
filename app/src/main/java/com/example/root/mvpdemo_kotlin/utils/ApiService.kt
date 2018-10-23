package com.example.root.mvpdemo_kotlin.utils

import com.example.root.mvpdemo_kotlin.entity.Book
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 *   author:Jiwenjie
 *   email:Jiwenjie97@gmail.com
 *   time:2018/10/20
 *   desc: 对外调用的接口
 *   version:1.0
 */
interface ApiService {

    @GET("book/search")
    fun getSearchBooks(@Query("q") name: String,
                       @Query("tag") tag: String, @Query("start") start: Int,
                       @Query("count") count: Int): Observable<Book>

}