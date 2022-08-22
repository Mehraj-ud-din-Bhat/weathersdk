package com.sdk.weatherlibrary.api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.*;


object RetrofitClient {

    const val BASE_URL = Urls.BASE_URL
    val retrofitClient: Retrofit.Builder by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val IWeather: IWeatherService by lazy {
        retrofitClient.build()
            .create(IWeatherService::class.java)
    }
}