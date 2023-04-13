package com.example.data.remote.mappers

import com.example.data.local.cameras.CameraDbo
import com.example.data.local.doors.DoorDbo
import com.example.data.remote.cameras.CameraDto
import com.example.data.remote.doors.DoorDto
import com.example.domain.data.Camera
import com.example.domain.data.Door
import java.util.*

fun CameraDto.toCameraDbo() =
    CameraDbo().apply {
        dbId = UUID.randomUUID().toString()
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

fun DoorDto.toDoorDbo() =
    DoorDbo().apply {
        dbId = UUID.randomUUID().toString()
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