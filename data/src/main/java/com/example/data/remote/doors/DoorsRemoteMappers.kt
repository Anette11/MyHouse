package com.example.data.remote.doors

import com.example.data.local.doors.DoorDbo

fun DoorDto.toDoorDbo() =
    DoorDbo().apply {
        favorites = this@toDoorDbo.favorites
        id = this@toDoorDbo.id
        name = this@toDoorDbo.name
        room = this@toDoorDbo.room
        snapshot = this@toDoorDbo.snapshot
    }