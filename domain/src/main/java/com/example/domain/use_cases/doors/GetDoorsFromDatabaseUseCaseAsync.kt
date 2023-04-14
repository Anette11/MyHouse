package com.example.domain.use_cases.doors

import com.example.domain.repositories.doors.DoorsRepository

class GetDoorsFromDatabaseUseCaseAsync(
    private val repository: DoorsRepository
) {
    suspend operator fun invoke() = repository.getDoorsFromDatabaseAsync()
}