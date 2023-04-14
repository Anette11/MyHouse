package com.example.domain.repositories.cameras

import com.example.domain.data.Camera
import kotlinx.coroutines.flow.Flow

interface CamerasRepository {

    suspend fun getInitialCameras()

    suspend fun refreshCameras()

    suspend fun getCamerasFromDatabaseAsync(): Flow<List<Camera>>

    suspend fun updateCamera(camera: Camera)
}