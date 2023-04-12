package com.example.domain.use_cases

import com.example.domain.data.Camera
import com.example.domain.repositories.CamerasRepository

class GetCamerasUseCase(
    private val repository: CamerasRepository
) {
    suspend operator fun invoke(): List<Camera> = repository.getCameras()
}