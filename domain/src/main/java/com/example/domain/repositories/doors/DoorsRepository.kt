package com.example.domain.repositories.doors

import com.example.domain.data.Door
import com.example.domain.repositories.NetworkResult
import kotlinx.coroutines.flow.Flow

interface DoorsRepository {

    suspend fun getInitialDoors(): Flow<NetworkResult>

    suspend fun refreshDoors(): Flow<NetworkResult>

    suspend fun getDoorsFromDatabaseAsync(): Flow<List<Door>>

    suspend fun updateDoor(door: Door)
}