package com.example.myhouse.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateTo(
    route: String,
    startDestination: String
) = this.navigate(route) {
    popUpTo(startDestination) {
        inclusive = true
    }
    launchSingleTop = true
}