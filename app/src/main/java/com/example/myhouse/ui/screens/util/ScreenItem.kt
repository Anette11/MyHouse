package com.example.myhouse.ui.screens.util

import com.example.domain.data.Camera
import com.example.domain.data.Door

sealed interface ScreenItem {

    data class CameraItem(
        val image: Any?,
        val name: String,
        val isRec: Boolean,
        val isFavourite: Boolean,
        val camera: Camera
    ) : ScreenItem

    data class TitleItem(
        val name: String
    ) : ScreenItem

    data class DoorItem(
        val image: Any?,
        val name: String,
        val status: String
    ) : ScreenItem

    data class SmallItem(
        val text: String,
        val isFavourite: Boolean,
        val door: Door
    ) : ScreenItem
}