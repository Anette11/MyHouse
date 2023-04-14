package com.example.domain.use_cases.cameras

import com.example.domain.repositories.CamerasRepository

class GetCamerasFromDatabaseUseCaseAsync(
    private val repository: CamerasRepository
) {
    suspend operator fun invoke() = repository.getCamerasFromDatabaseAsync()
}