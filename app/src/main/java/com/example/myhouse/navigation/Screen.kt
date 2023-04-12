package com.example.myhouse.navigation

sealed class Screen(
    val route: String,
    val tabName: String
) {
    object Cameras : Screen(
        route = "cameras_route",
        tabName = "Камеры"
    )

    object Doors : Screen(
        route = "doors_route",
        tabName = "Двери"
    )
}