package com.example.myhouse.ui.screens.util

sealed interface ScreenItem {

    data class CameraItem(
        val image: Any?,
        val name: String,
        val isRec: Boolean,
        val isFavourite: Boolean
    ) : ScreenItem

    data class TitleItem(
        val name: String
    ) : ScreenItem
}