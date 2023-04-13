package com.example.domain.use_cases

import com.example.domain.repositories.CamerasRepository

class GetInitialCamerasUseCase(
    private val repository: CamerasRepository
) {
    suspend operator fun invoke() = repository.getInitialCameras()
}