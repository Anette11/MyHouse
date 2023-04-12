package com.example.myhouse.navigation

sealed class Screen(
    val tabName: String
) {
    object Cameras : Screen(
        tabName = "Камеры"
    )

    object Doors : Screen(
        tabName = "Двери"
    )
}