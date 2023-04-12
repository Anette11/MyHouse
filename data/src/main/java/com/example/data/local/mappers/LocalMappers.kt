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