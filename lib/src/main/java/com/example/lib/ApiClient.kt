package com.example.lib

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ApiClient {

    private val API_BASE_URL = "https://run.mocky.io/v3/"

    private val okHttpBuilder: OkHttpClient.Builder by lazy {
        OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
    }

    val retrofit: Retrofit by lazy {
        // Creating kotlinx-serialization converter factory for Retrofit
        val contentType = "application/json".toMediaType()
        val kotlinxConverterFactory = Json.asConverterFactory(contentType)

        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(kotlinxConverterFactory)
            .client(okHttpBuilder.build())
            .build()
    }
}
