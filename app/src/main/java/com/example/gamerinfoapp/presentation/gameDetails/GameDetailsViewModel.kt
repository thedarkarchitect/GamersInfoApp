package com.example.gamerinfoapp.presentation.gameDetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamerinfoapp.domain.repository.GameRepository
import com.example.gamerinfoapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    private val repository: GameRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val gameId = savedStateHandle.get<Int>("gameId")

    private val _gamesDetailState = MutableStateFlow(GameDetailsState())
    val gamesDetailState = _gamesDetailState.asStateFlow()

    init {
        Log.d("gameId", "The id $gameId" )
        getGameById(gameId ?: -1)
    }

    private fun getGameById(id: Int) {
        viewModelScope.launch {
            repository.getGamesById(id).collectLatest { gameDetails ->
                when(gameDetails) {
                    is Resource.Error -> {
                        _gamesDetailState.update{
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _gamesDetailState.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    is Resource.Success -> {
                        gameDetails.data.let { gameDetailsdto ->
                            _gamesDetailState.update {
                                it.copy(
                                    gameInfo = gameDetailsdto
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
