package com.example.domain.use_cases.doors

import com.example.domain.data.Door
import com.example.domain.repositories.doors.DoorsRepository

class UpdateDoorUseCase(
    private val repository: DoorsRepository
) {
    suspend operator fun invoke(door: Door) = repository.updateDoor(door = door)
}