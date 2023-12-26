package com.example.gamerinfoapp.presentation.gameDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gamerinfoapp.presentation.gameDetails.GameDetailsViewModel

@Composable
fun DetailScreen() {

    val detailsViewModel = hiltViewModel<GameDetailsViewModel>()
    val detailsState = detailsViewModel.gamesDetailState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(detailsState.gameInfo?.thumbnail)
                .crossfade(true)
                .build()
            , contentDescription = null
        )
        detailsState.gameInfo?.title?.let { Text(text = it) }
        detailsState.gameInfo?.description?.let { Text( text = it) }
    }

}