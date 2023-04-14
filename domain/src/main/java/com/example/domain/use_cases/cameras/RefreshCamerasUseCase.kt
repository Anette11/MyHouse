package com.example.domain.use_cases.cameras

import com.example.domain.repositories.CamerasRepository

class RefreshCamerasUseCase(
    private val repository: CamerasRepository
) {
    suspend operator fun invoke() = repository.refreshCameras()
}