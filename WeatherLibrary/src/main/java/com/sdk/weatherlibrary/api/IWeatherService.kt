package com.sdk.weatherlibrary.api


import com.sdk.weatherlibrary.models.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface  IWeatherService {

    @GET("data/2.5/weather?")
    fun getCurrentWeather(@Query("lat") lat: String, @Query("lon") lon: String, @Query("APPID") app_id: String): Call<WeatherModel>
    @GET("data/2.5/weather?")
    fun getWeatherForecast(@Query("lat") lat: String, @Query("lon") lon: String,@Query("cnt") cnt:String, @Query("APPID") app_id: String): Call<WeatherModel>


}

