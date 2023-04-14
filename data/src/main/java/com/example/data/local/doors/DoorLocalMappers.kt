package com.example.data.local.doors

import com.example.domain.data.Door

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

fun Door.toDoorDbo() =
    DoorDbo().apply {
        favorites = this@toDoorDbo.favorites
        id = this@toDoorDbo.id
        name = this@toDoorDbo.name
        room = this@toDoorDbo.room
        snapshot = this@toDoorDbo.snapshot
    }