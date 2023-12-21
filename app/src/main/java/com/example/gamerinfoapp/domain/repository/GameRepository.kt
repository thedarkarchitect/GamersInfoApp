package com.example.gamerinfoapp.domain.repository

import com.example.gamerinfoapp.data.remote.dto.GameDetailsdto
import com.example.gamerinfoapp.data.remote.dto.GameDto
import com.example.gamerinfoapp.domain.model.Game
import com.example.gamerinfoapp.domain.model.GameDetails
import com.example.gamerinfoapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    suspend fun getGames(): Flow<Resource<List<GameDto>>>
    suspend fun getGamesById(id: Int): Flow<Resource<GameDetailsdto>>
}