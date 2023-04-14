package com.example.domain.repositories

import com.example.domain.data.Camera
import kotlinx.coroutines.flow.Flow

interface CamerasRepository {

    suspend fun getInitialCameras()

    suspend fun refreshCameras()

    suspend fun getCamerasFromDatabaseAsync(): Flow<Camera>
}