package com.example.myhouse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myhouse.ui.screens.cameras.CamerasScreen
import com.example.myhouse.ui.screens.doors.DoorsScreen

@Composable
fun HouseNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Cameras.route
) = NavHost(
    navController = navController,
    startDestination = startDestination
) {
    composable(
        route = Screen.Cameras.route
    ) {
        CamerasScreen()
    }
    composable(
        route = Screen.Doors.route
    ) {
        DoorsScreen()
    }
}