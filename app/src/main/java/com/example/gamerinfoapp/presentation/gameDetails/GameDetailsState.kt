package com.example.gamerinfoapp.presentation.gameDetails

import com.example.gamerinfoapp.data.remote.dto.GameDetailsdto

data class GameDetailsState(
    val isLoading: Boolean = false,
    val gameInfo: GameDetailsdto? = null
)
