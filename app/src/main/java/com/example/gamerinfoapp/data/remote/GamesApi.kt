package com.example.gamerinfoapp.data.remote

import com.example.gamerinfoapp.data.remote.dto.GameDetailsdto
import com.example.gamerinfoapp.data.remote.dto.GameDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {
    @GET("games")
    suspend fun getgames(): ArrayList<GameDto>

    @GET("games")
    suspend fun getGameById(
        @Query(value = "id")
        id: Int
    ): GameDetailsdto
}