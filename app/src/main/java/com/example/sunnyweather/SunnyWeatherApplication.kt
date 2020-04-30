package com.example.sunnyweather

import android.app.Application
import android.content.Context

/**
 *@Date 2020/4/30
 *@author Chen
 *@Description
 */
class SunnyWeatherApplication: Application() {

    companion object{
        lateinit var context: Context
        const val TOKEN  = "E0QkjrXRsqxmhVBh"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}