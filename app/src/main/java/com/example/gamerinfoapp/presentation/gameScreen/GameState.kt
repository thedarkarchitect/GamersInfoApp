package com.example.gamerinfoapp.presentation.gameScreen

import androidx.compose.runtime.MutableState
import com.example.gamerinfoapp.data.remote.dto.GameDto

data class GameState(
    val isLoading: Boolean = false,
    val error: String = "",
    val gameList: List<GameDto> = emptyList(),

)
