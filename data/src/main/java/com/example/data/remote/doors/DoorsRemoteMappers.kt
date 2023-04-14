package com.example.data.remote.doors

import com.example.data.local.doors.DoorDbo
import com.example.domain.data.Door

fun DoorDto.toDoorDbo() =
    DoorDbo().apply {
        favorites = this@toDoorDbo.favorites
        id = this@toDoorDbo.id
        name = this@toDoorDbo.name
        room = this@toDoorDbo.room
        snapshot = this@toDoorDbo.snapshot
    }

fun DoorDto.toDoor() =
    with(this) {
        Door(
            favorites = favorites,
            id = id,
            name = name,
            room = room,
            snapshot = snapshot
        )
    }