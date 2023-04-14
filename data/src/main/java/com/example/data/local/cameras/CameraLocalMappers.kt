package com.example.data.local.cameras

import com.example.domain.data.Camera

fun CameraDbo.toCamera() =
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

fun Camera.toCameraDbo() =
    CameraDbo(
    ).apply {
        favorites = this@toCameraDbo.favorites
        id = this@toCameraDbo.id
        name = this@toCameraDbo.name
        rec = this@toCameraDbo.rec
        room = this@toCameraDbo.room
        snapshot = this@toCameraDbo.snapshot
    }