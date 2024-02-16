package com.example.myapplication.network

import retrofit2.http.GET

interface APIinterface {

    @GET("s3k6-pzi2")
    suspend fun getSchools(): List<SchoolData>

}