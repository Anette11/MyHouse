package com.example.myhouse.ui.screens.util

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