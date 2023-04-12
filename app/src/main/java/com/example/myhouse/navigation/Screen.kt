package com.example.myhouse.navigation

sealed class Screen(
    val route: String
) {
    object Cameras : Screen(
        route = "cameras_route"
    )

    object Doors : Screen(
        route = "doors_route"
    )
}