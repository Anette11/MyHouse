package com.example.myhouse.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val _0dp: Dp = 0.dp,
    val _1dp: Dp = 1.dp,
    val _2dp: Dp = 2.dp,
    val _8dp: Dp = 8.dp,
    val _12dp: Dp = 12.dp,
    val _14dp: Dp = 14.dp,
    val _16dp: Dp = 16.dp,
    val _21dp: Dp = 21.dp,
    val _28dp: Dp = 28.dp,
    val _29dp: Dp = 29.dp,
    val _36dp: Dp = 36.dp,
    val _207dp: Dp = 207.dp
)

val LocalDimens = compositionLocalOf { Dimens() }

val dimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current