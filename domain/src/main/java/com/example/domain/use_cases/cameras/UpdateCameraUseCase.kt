package com.example.domain.use_cases.cameras

import com.example.domain.data.Camera
import com.example.domain.repositories.cameras.CamerasRepository

class UpdateCameraUseCase(
    private val repository: CamerasRepository
) {
    suspend operator fun invoke(camera: Camera) = repository.updateCamera(camera = camera)
}