package com.example.myhouse.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Elevation(
    val default: Dp = 0.dp,
    val small: Dp = 4.dp
)

val LocalElevation = compositionLocalOf { Elevation() }

val elevation: Elevation
    @Composable
    @ReadOnlyComposable
    get() = LocalElevation.current