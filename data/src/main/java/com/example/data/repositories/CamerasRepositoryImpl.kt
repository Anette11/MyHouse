package com.example.data.repositories

import com.example.data.remote.NetworkWebservice
import com.example.data.remote.mappers.toCamera
import com.example.domain.data.Camera
import com.example.domain.repositories.CamerasRepository
import javax.inject.Inject

class CamerasRepositoryImpl @Inject constructor(
    private val networkWebservice: NetworkWebservice
) : CamerasRepository {

    override suspend fun getCameras(): List<Camera> =
        try {
            val getCamerasResponse = networkWebservice.getCameras()
            getCamerasResponse.data?.cameras?.map { cameraDto -> cameraDto.toCamera() }
                ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
}