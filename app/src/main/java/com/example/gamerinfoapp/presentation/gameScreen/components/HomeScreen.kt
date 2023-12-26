package com.example.gamerinfoapp.presentation.gameScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gamerinfoapp.presentation.gameScreen.GameState
import com.example.gamerinfoapp.utils.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
//    modifier: Modifier = Modifier,
    state: GameState,
    navController: NavController
) {
    
    LazyColumn{
        items(state.gameList){game ->
            Card(
                onClick = {
                    navController.navigate(
                        Screen.DetailScreen.route + "/${game.id}"
                    )
                }
            ) {
                Column {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(game.thumbnail)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Text(text = game.short_description)
                }
            }
        }
    }
}