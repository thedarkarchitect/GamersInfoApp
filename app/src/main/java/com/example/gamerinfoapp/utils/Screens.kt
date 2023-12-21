package com.example.gamerinfoapp.utils

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object DetailScreen: Screen("detail_screen")
}