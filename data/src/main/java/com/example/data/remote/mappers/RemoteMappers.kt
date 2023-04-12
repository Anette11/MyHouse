package com.example.data.remote.mappers

import com.example.data.local.cameras.CameraDbo
import com.example.data.local.doors.DoorDbo
import com.example.data.remote.cameras.CameraDto
import com.example.data.remote.doors.DoorDto
import com.example.domain.data.Camera
import com.example.domain.data.Door

fun CameraDto.toCameraDbo() =
    with(this) {
        CameraDbo(
            favorites = favorites,
            id = id,
            name = name,
            rec = rec,
            room = room,
            snapshot = snapshot
        )
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
    with(this) {
        DoorDbo(
            favorites = favorites,
            id = id,
            name = name,
            room = room,
            snapshot = snapshot
        )
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