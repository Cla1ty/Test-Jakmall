package com.dwiariyanto.testjakmall.data.repository

import com.dwiariyanto.testjakmall.data.model.joke.JokeData
import com.dwiariyanto.testjakmall.data.repository.impl.JokeRepositoryImpl
import io.reactivex.Observable

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */

interface JokeRepository{
    fun getRandom(): Observable<List<JokeData>>

    companion object {
        val get: JokeRepository by lazy { JokeRepositoryImpl() }
    }
}