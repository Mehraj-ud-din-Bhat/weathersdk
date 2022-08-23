package com.sdk.weathersdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sdk.weatherlibrary.main.IWeatherCallback
import com.sdk.weatherlibrary.main.WeatherAPIController
import com.sdk.weatherlibrary.models.WeatherModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WeatherAPIController.getInstance(applicationContext).getCurrentWeather("12","12.99",object :IWeatherCallback{
            override fun onWeatherDataReceived(model: WeatherModel) {

            }

            override fun onError(msg: String) {

            }

        })


        WeatherAPIController.getInstance(applicationContext).getForecast("12","12.99","10",object :IWeatherCallback{
            override fun onWeatherDataReceived(model: WeatherModel) {

            }

            override fun onError(msg: String) {

            }

        })



    }
}