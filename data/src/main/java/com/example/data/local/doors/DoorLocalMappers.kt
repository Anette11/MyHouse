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