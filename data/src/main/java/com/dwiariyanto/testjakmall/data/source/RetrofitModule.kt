package com.dwiariyanto.testjakmall.data.source

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object RetrofitModule {
    const val BASE_URL = "https://api.icndb.com/"
    const val DEBUG = true

    val retrofit: Retrofit by lazy {
        createRetrofit(
            BASE_URL,
            loggerBody()
        )
    }

    val retrofitForStreaming: Retrofit by lazy {
        createRetrofit(
            BASE_URL,
            loggerHeader()
        )
    }

    private fun loggerHeader() =
        HttpLoggingInterceptor().setLevel(if (DEBUG) HttpLoggingInterceptor.Level.HEADERS else HttpLoggingInterceptor.Level.NONE)

    private fun loggerBody() =
        HttpLoggingInterceptor().setLevel(if (DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

    private fun createOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)
            .build()
    }

    private fun createRetrofit(baseUrl: String, logger: HttpLoggingInterceptor): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(createOkHttpClient(logger))
            .build()
}