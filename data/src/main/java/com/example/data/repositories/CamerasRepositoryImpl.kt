package com.example.data.repositories

import com.example.data.local.cameras.CamerasDao
import com.example.data.local.mappers.toCamera
import com.example.data.remote.NetworkWebservice
import com.example.data.remote.mappers.toCameraDbo
import com.example.domain.data.Camera
import com.example.domain.repositories.CamerasRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import timber.log.Timber
import javax.inject.Inject

class CamerasRepositoryImpl @Inject constructor(
    private val networkWebservice: NetworkWebservice,
    private val camerasDao: CamerasDao
) : CamerasRepository {

    override suspend fun getInitialCameras() =
        try {
            when (camerasDao.getCamerasFromDatabase().isNotEmpty()) {
                true -> Unit
                false -> fetchCamerasAndSaveInDatabase()
            }
        } catch (e: Exception) {
            Timber.d(e.printStackTrace().toString())
        }

    override suspend fun refreshCameras() =
        try {
            fetchCamerasAndSaveInDatabase()
        } catch (e: Exception) {
            Timber.d(e.printStackTrace().toString())
        }

    override suspend fun getCamerasFromDatabaseAsync(): Flow<Camera> =
        camerasDao.getCamerasFromDatabaseAsync()
            .map { cameraDbo -> cameraDbo.toCamera() }
            .asFlow()

    private suspend fun fetchCamerasAndSaveInDatabase() {
        val getCamerasResponse = networkWebservice.getCameras()
        val newCameras = getCamerasResponse.data?.cameras?.map { cameraDto ->
            cameraDto.toCameraDbo()
        } ?: emptyList()
        camerasDao.updateCamerasInDatabase(newList = newCameras)
    }
}