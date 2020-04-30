package com.example.sunnyweather.logic.network

import com.example.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *@Date 2020/4/30
 *@author Chen
 *@Description
 */
object SunnyWeatherNetwork {

    //创建一个retrofit的动态代理对象
    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

//    private suspend fun <T> Call<T>.await(): T{
//        return suspendCoroutine {
//            enqueue(object : Callback<T>{
//                override fun onFailure(call: Call<T>, t: Throwable) {
//                    it.resumeWithException(t)
//                }
//
//                override fun onResponse(call: Call<T>, response: Response<T>) {
//                    val response = response.body()
//                    if (response != null) it.resume(response)
//                    else it.resumeWithException(RuntimeException("response body is null"))
//                }
//
//            })
//        }
//    }
}