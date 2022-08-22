package com.sdk.weatherlibrary.main

import com.sdk.weatherlibrary.models.WeatherModel

interface  IWeatherCallback {
    fun onWeatherDataReceived(model: WeatherModel)
    fun onError(msg:String)
}