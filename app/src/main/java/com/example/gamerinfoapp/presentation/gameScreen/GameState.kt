package com.example.gamerinfoapp.presentation.gameScreen


import com.example.gamerinfoapp.data.remote.dto.GameDto

data class GameState(
    val isLoading: Boolean = false,
    val error: String = "",
    val gameList: ArrayList<GameDto> = arrayListOf(),

    )
