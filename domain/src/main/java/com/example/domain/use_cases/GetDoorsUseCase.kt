package com.example.domain.use_cases

import com.example.domain.data.Door
import com.example.domain.repositories.DoorsRepository

class GetDoorsUseCase(
    private val repository: DoorsRepository
) {
    suspend operator fun invoke(): List<Door> = repository.getDoors()
}