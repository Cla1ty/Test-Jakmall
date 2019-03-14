package com.dwiariyanto.testjakmall.data.source.service

import com.dwiariyanto.testjakmall.data.source.RetrofitModule
import com.dwiariyanto.testjakmall.data.source.model.JokeResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
interface JokeService {
    @GET("jokes/random/10-")
    fun getRandom(): Observable<JokeResponse>

    companion object {
        val get by lazy { RetrofitModule.retrofit.create(JokeService::class.java) }
    }
}