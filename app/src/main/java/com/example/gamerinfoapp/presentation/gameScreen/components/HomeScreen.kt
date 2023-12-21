package com.example.gamerinfoapp.presentation.gameScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gamerinfoapp.presentation.gameScreen.GameViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: GameViewModel
) {
    
    LazyColumn{
        items(state.gamesState.gameList){
            Card {
                Column {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(it.thumbnail)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Text(text = it.short_description)
                }
            }
        }
    }
}