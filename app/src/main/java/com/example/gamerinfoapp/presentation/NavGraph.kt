package com.example.gamerinfoapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gamerinfoapp.presentation.gameDetails.components.DetailScreen
import com.example.gamerinfoapp.presentation.gameScreen.GameViewModel
import com.example.gamerinfoapp.presentation.gameScreen.components.HomeScreen
import com.example.gamerinfoapp.utils.Screen

@Composable
fun NavGraph(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            val viewModel = hiltViewModel<GameViewModel>()
            val state = viewModel.gamesState.collectAsState().value
            HomeScreen(
                state = state
                , navController = navController
            )
        }

        composable(
            route = Screen.DetailScreen.route + "/{gameId}",
            arguments = listOf(
                navArgument("gameId") { type = NavType.IntType }
            )
        ){
            DetailScreen()
        }
    }
}