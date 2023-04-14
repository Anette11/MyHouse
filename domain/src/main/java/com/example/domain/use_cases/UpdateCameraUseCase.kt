package com.example.domain.use_cases

import com.example.domain.data.Camera
import com.example.domain.repositories.CamerasRepository

class UpdateCameraUseCase(
    private val repository: CamerasRepository
) {
    suspend operator fun invoke(camera: Camera) = repository.updateCamera(camera = camera)
}