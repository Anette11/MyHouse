package com.example.data.repositories

import com.example.data.local.cameras.CameraDbo
import com.example.data.local.mappers.toCamera
import com.example.data.remote.NetworkWebservice
import com.example.data.remote.mappers.toCameraDbo
import com.example.domain.data.Camera
import com.example.domain.repositories.CamerasRepository
import io.realm.Realm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class CamerasRepositoryImpl @Inject constructor(
    private val networkWebservice: NetworkWebservice,
    private val realm: Realm
) : CamerasRepository {

    override suspend fun getInitialCameras() =
        try {
            val camerasInDBIsNotEmpty = realm
                .where(CameraDbo::class.java)
                .findAll()
                .isNotEmpty()
            when (camerasInDBIsNotEmpty) {
                true -> Unit
                false -> fetchCamerasAnSaveInDatabase()
            }
        } catch (e: Exception) {
            Timber.d(e.localizedMessage)
        }

    override suspend fun refreshCameras() =
        try {
            fetchCamerasAnSaveInDatabase()
        } catch (e: Exception) {
            Timber.d(e.localizedMessage)
        }

    override suspend fun getCamerasFromDatabase(): Flow<List<Camera>> = flow {
        val cameras = realm.where(CameraDbo::class.java).findAll().toList().map { cameraDbo ->
            cameraDbo.toCamera()
        }
        emit(cameras)
    }

    private suspend fun fetchCamerasAnSaveInDatabase() {
        val getCamerasResponse = networkWebservice.getCameras()
        val newCameras = getCamerasResponse.data?.cameras?.map { cameraDto ->
            cameraDto.toCameraDbo()
        } ?: emptyList()
        realm.executeTransaction { realm ->
            realm.delete(CameraDbo::class.java)
            realm.insert(newCameras)
        }
    }
}