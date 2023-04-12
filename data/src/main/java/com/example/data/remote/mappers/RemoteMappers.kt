package com.example.data.remote.mappers

import com.example.data.local.doors.DoorDbo
import com.example.data.remote.doors.DoorDto

fun DoorDto.toDoorDbo() =
    with(this) {
        DoorDbo(
            favorites = favorites,
            id = id,
            name = name,
            room = room,
            snapshot = snapshot
        )
    }