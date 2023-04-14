package com.example.domain.repositories.doors

import com.example.domain.data.Door
import kotlinx.coroutines.flow.Flow

interface DoorsRepository {

    suspend fun getInitialDoors()

    suspend fun refreshDoors()

    suspend fun getDoorsFromDatabaseAsync(): Flow<List<Door>>

    suspend fun updateDoor(door: Door)
}