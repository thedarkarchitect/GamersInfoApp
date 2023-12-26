package com.example.gamerinfoapp.data.repository

import com.example.gamerinfoapp.data.remote.GamesApi
import com.example.gamerinfoapp.data.remote.dto.GameDetailsdto
import com.example.gamerinfoapp.data.remote.dto.GameDto
import com.example.gamerinfoapp.domain.model.Game
import com.example.gamerinfoapp.domain.model.GameDetails
import com.example.gamerinfoapp.domain.repository.GameRepository
import com.example.gamerinfoapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val api: GamesApi
): GameRepository {
    override suspend fun getGames(): Flow<Resource<ArrayList<GameDto>>> =
        flow{
           emit(Resource.Loading())
           try {
               val result = api.getgames()
               emit(Resource.Success(data = result))
               return@flow
           } catch (e:Exception) {
                e.printStackTrace()
               emit(Resource.Error(data = null, message = "Error Loading the games"))
               return@flow
           }
        }

    override suspend fun getGamesById(id: Int): Flow<Resource<GameDetailsdto>> = flow {
        emit(Resource.Loading())
        try {
            val result = api.getGameById(id)
            emit(Resource.Success(data = result))
            return@flow
        } catch (e:Exception) {
            e.printStackTrace()
            emit(Resource.Error(data = null, message = "Error Loading the games"))
            return@flow
        }
    }
}