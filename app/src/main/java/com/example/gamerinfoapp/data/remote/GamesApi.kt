package com.example.gamerinfoapp.data.remote

import com.example.gamerinfoapp.data.remote.dto.GameDetailsdto
import com.example.gamerinfoapp.data.remote.dto.GameDto
import com.example.gamerinfoapp.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {
    @GET("games")
    suspend fun getgames(): List<GameDto>

    @GET("games?id")
    suspend fun getGameById(
        @Query(value = "id")
        id: Int
    ): GameDetailsdto
}