package com.example.gamerinfoapp.presentation.gameScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamerinfoapp.domain.repository.GameRepository
import com.example.gamerinfoapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: GameRepository
): ViewModel() {

    var gamesState by mutableStateOf(GameState())
        private set

    init {
        getGameList()
    }

    private fun getGameList() {
        viewModelScope.launch {
            repository.getGames().collectLatest {  result ->
                when(result) {
                    is Resource.Error -> {
                        gamesState = gamesState.copy(
                            isLoading = false,
                            gameList = emptyList(),
                            error = result.message ?: ""
                        )
                    }
                    is Resource.Loading -> {
                        gamesState = gamesState.copy(
                            isLoading = true,
                            gameList = emptyList(),
                            error = result.message ?: ""
                        )
                    }
                    is Resource.Success -> {
                        gamesState = gamesState.copy(
                            isLoading = false,
                            gameList = result.data ?: emptyList(),
                            error = result.message ?: ""
                        )
                    }
                }
            }
        }
    }
}