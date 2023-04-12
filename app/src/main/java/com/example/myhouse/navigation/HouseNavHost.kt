package com.example.myhouse.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myhouse.ui.screens.cameras.CamerasScreen
import com.example.myhouse.ui.screens.doors.DoorsScreen
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HouseNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Cameras.route,
    navigateToRoute: SharedFlow<String>
) {
    LaunchedEffect(key1 = Unit) {
        navigateToRoute.collectLatest { route ->
            navController.navigate(route = route)
        }
    }

    NavHost(
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
}