package com.example.data.remote.cameras

data class CameraDto(
    val favorites: Boolean?,
    val id: Int?,
    val name: String?,
    val rec: Boolean?,
    val room: String?,
    val snapshot: String?
)