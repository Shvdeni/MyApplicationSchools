package com.example.myapplication

import com.example.myapplication.network.APIinterface
import com.example.myapplication.network.RetrofitClient
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class APITest {

    @Test
    suspend fun myAPITest () {
        // call the api
//        val api = APIinterface.create("yourapi.com")
        val api = RetrofitClient.api
//        val response = api.getPaymentMethod("authToken").execute()
        val response = api.getSchools()
        // verify the response is OK
        assertThat(response.code).isEqualTo(200)
    }

}