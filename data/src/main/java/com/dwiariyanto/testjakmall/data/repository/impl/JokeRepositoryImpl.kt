package com.dwiariyanto.testjakmall.data.repository.impl

import com.dwiariyanto.testjakmall.data.repository.JokeRepository
import com.dwiariyanto.testjakmall.data.source.service.JokeService

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
class JokeRepositoryImpl(
    val service: JokeService = JokeService.get
) : JokeRepository {
    override fun getRandom() =
        service.getRandom()
            .map { it.value ?: emptyList() }
            .map { it.sortedBy { it.id } }!!
}