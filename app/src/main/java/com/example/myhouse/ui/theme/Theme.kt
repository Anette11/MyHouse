package com.example.myhouse.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = BlueSky,
    primaryVariant = GrayMedium,
    secondary = BlueSky,
    background = GrayMedium,
    onBackground = GrayDark,
    onPrimary = GrayDark,
    surface = White,
    onSurface = GrayDark,
    onSecondary = GrayDark
)

private val LightColorPalette = lightColors(
    primary = BlueSky,
    primaryVariant = GrayMedium,
    secondary = BlueSky,
    background = GrayMedium,
    onBackground = GrayDark,
    onPrimary = GrayDark,
    surface = White,
    onSurface = GrayDark,
    onSecondary = GrayDark
)

@Composable
fun MyHouseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}