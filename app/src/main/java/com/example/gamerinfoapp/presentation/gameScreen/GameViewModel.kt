package com.example.gamerinfoapp.presentation.gameScreen

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
class GameViewModel @Inject constructor(
    private val repository: GameRepository
): ViewModel() {

    private val _gamesState = MutableStateFlow(GameState())
    val gamesState = _gamesState.asStateFlow()

    init {
        getGameList()
    }

    private fun getGameList() {
        viewModelScope.launch {
            repository.getGames().collectLatest {  result ->
                when(result) {
                    is Resource.Error -> {
                        _gamesState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _gamesState.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    is Resource.Success -> {
                        result.data?.let { gameList ->
                            _gamesState.update {
                                it.copy(
                                    gameList = gameList
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}