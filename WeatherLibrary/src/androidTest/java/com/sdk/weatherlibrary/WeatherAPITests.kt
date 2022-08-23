package com.sdk.weatherlibrary


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.sdk.weatherlibrary.main.IWeatherCallback
import com.sdk.weatherlibrary.main.WeatherAPIController
import com.sdk.weatherlibrary.models.WeatherModel
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch


@RunWith(AndroidJUnit4::class)
class WeatherAPITests {

    @Test

    fun getWeatherForecastData()
    {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val latch:CountDownLatch= CountDownLatch(1)
        var weatherModel:WeatherModel?=null
        WeatherAPIController.getInstance(appContext).getForecast("12","53","7",object :IWeatherCallback{
            override fun onWeatherDataReceived(model: WeatherModel) {
                weatherModel=model
               latch.countDown()
            }

            override fun onError(msg: String) {
               // assertThat(false).isTrue()
                latch.countDown()
            }

        })
        latch.await()

        assertThat(weatherModel).isNotNull()



    }

    fun getCurrentWeather()
    {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val latch:CountDownLatch= CountDownLatch(1)
        var weatherModel:WeatherModel?=null
        WeatherAPIController.getInstance(appContext).getCurrentWeather("12","53",object :IWeatherCallback{
            override fun onWeatherDataReceived(model: WeatherModel) {
                weatherModel=model
                latch.countDown()
            }

            override fun onError(msg: String) {
                // assertThat(false).isTrue()
                latch.countDown()
            }

        })
        latch.await()

        assertThat(weatherModel).isNotNull()



    }
}