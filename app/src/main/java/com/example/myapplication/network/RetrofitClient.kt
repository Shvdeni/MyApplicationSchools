package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

companion object{
    val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:APIinterface by lazy {
        retrofit.create(APIinterface::class.java)
    }


}

}