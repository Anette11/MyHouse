package com.example.domain.repositories

import com.example.domain.data.Camera

interface CamerasRepository {

    suspend fun getCameras(): List<Camera>
}