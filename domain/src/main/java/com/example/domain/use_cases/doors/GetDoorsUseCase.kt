package com.example.domain.use_cases.doors

import com.example.domain.data.Door
import com.example.domain.repositories.doors.DoorsRepository

class GetDoorsUseCase(
    private val repository: DoorsRepository
) {
    suspend operator fun invoke(): List<Door> = repository.getDoors()
}