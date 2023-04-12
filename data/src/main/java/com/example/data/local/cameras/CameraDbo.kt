package com.example.data.local.cameras

data class CameraDbo(
    val favorites: Boolean?,
    val id: Int?,
    val name: String?,
    val rec: Boolean?,
    val room: String?,
    val snapshot: String?
)