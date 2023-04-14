package com.example.domain.repositories.cameras

import com.example.domain.data.Camera
import com.example.domain.repositories.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CamerasRepository {

    suspend fun getInitialCameras(): Flow<NetworkResult<List<Camera>>>

    suspend fun refreshCameras()

    suspend fun getCamerasFromDatabaseAsync(): Flow<List<Camera>>

    suspend fun updateCamera(camera: Camera)
}