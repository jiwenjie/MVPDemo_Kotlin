package com.example.root.mvpdemo_kotlin.utils

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

/**
 *   author:Jiwenjie
 *   email:Jiwenjie97@gmail.com
 *   time:2018/10/20
 *   desc: Retrofit 的工具类
 *   version:1.0
 */
class RetrofitHelper private constructor(context: Context, baseUrl: String){

    val mContext: Context = context
    var okHttpClient: OkHttpClient? = null
    var retrofit: Retrofit? = null
    val DEFAULT_TIMEOUT : Long = 20
    val url = baseUrl

    init {
        // 创建 okHttp
        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()

        // 创建 retrofit
        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
    }

    // 等同于类的静态函数
    companion object {
        @Volatile
        var instance: RetrofitHelper? = null

        fun getInstance(context: Context, baseUrl: String) : RetrofitHelper {
            if (instance == null) {
                synchronized(RetrofitHelper::class.java) {
                    if (instance == null) {
                        instance = RetrofitHelper(context, baseUrl)
                    }
                }
            }
            return instance!!
        }
    }

    // 通过该方法来获取 ApiService
    fun <T> create(service: Class<T>?): T? {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return retrofit?.create(service)
    }

}












