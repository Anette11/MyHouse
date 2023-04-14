package com.example.data.local.mappers

import com.example.data.local.cameras.CameraDbo
import com.example.data.local.doors.DoorDbo
import com.example.domain.data.Camera
import com.example.domain.data.Door

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

fun DoorDbo.toDoor() =
    with(this) {
        Door(
            favorites = favorites,
            id = id,
            name = name,
            room = room,
            snapshot = snapshot
        )
    }