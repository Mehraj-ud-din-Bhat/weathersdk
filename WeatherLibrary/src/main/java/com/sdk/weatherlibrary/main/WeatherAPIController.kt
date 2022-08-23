package com.sdk.weatherlibrary.main

import android.content.Context
import com.sdk.weatherlibrary.api.RetrofitClient
import com.sdk.weatherlibrary.api.Urls
import com.sdk.weatherlibrary.models.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public  class WeatherAPIController(val context: Context){

    companion object {
     private   var instance:WeatherAPIController?=null
        fun getInstance(context: Context): WeatherAPIController {
            if (instance == null)
                instance= WeatherAPIController(context)
            return instance!!
        }
    }



   fun getCurrentWeather(lat:String, long:String,callBack:IWeatherCallback)
   {

       val call = RetrofitClient.IWeather.getCurrentWeather(lat,long,Urls.API_KEY)

       call.enqueue(object: Callback<WeatherModel>{
           override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
               if(response.isSuccessful && response.code()==200)
               {
                   callBack.onWeatherDataReceived(response.body()!!)

               }else{
                   callBack.onError(response.message()!!)
               }

           }

           override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
               callBack.onError(t.message!!)
           }
       })



   }




  fun getForecast(lat:String, long:String,days:String,callBack: IWeatherCallback){
      val call = RetrofitClient.IWeather.getWeatherForecast(lat,long,days,Urls.API_KEY)

      call.enqueue(object: Callback<WeatherModel>{
          override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
              if(response.isSuccessful && response.code()==200)
              {
                  callBack.onWeatherDataReceived(response.body()!!)

              }else{
                  callBack.onError(response.message()!!)
              }

          }

          override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
              callBack.onError(t.message!!)
          }
      })
  }




}