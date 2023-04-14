package com.example.data.remote.cameras

import com.example.data.local.cameras.CameraDbo
import com.example.domain.data.Camera

fun CameraDto.toCameraDbo() =
    CameraDbo().apply {
        favorites = this@toCameraDbo.favorites
        id = this@toCameraDbo.id
        name = this@toCameraDbo.name
        rec = this@toCameraDbo.rec
        room = this@toCameraDbo.room
        snapshot = this@toCameraDbo.snapshot
    }

fun CameraDto.toCamera() =
    with(this) {
        Camera(
            favorites = favorites,
            id = id,
            name = name,
            rec = rec,
            room = room,
            snapshot = snapshot
        )
    }