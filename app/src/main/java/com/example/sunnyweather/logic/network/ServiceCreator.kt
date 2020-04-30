package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *@Date 2020/4/30
 *@author Chen
 *@Description
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"

    //创建Retrofit实例，通过Builder()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //创建动态代理对象  基本写法： retrofit.create(PlaceService::class.java) 这只是对应一个retrofit，因为后面一个PlaceService是写死的
    //如何才能做成通用的？利用泛型来进行优化
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    //再利用泛型的实化，对代码优化
    inline fun <reified T> create(): T = create(T::class.java)
}