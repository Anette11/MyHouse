package com.example.data.repositories.doors

import com.example.data.local.doors.DoorsDao
import com.example.data.local.doors.toDoor
import com.example.data.local.doors.toDoorDbo
import com.example.data.remote.doors.DoorsNetworkWebservice
import com.example.data.remote.doors.toDoorDbo
import com.example.domain.data.Door
import com.example.domain.repositories.NetworkResult
import com.example.domain.repositories.doors.DoorsRepository
import io.realm.kotlin.toFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class DoorsRepositoryImpl @Inject constructor(
    private val doorsNetworkWebservice: DoorsNetworkWebservice,
    private val doorsDao: DoorsDao
) : DoorsRepository {

    override suspend fun getInitialDoors(): Flow<NetworkResult> = flow {
        emit(NetworkResult.Loading)
        try {
            when (doorsDao.getDoorsFromDatabase().isNotEmpty()) {
                true -> Unit
                false -> fetchDoorsAndSaveInDatabase()
            }
            emit(NetworkResult.Success)
        } catch (e: Exception) {
            Timber.d(e.printStackTrace().toString())
            emit(NetworkResult.Failure)
        }
    }

    override suspend fun refreshDoors(): Flow<NetworkResult> = flow {
        emit(NetworkResult.Loading)
        try {
            fetchDoorsAndSaveInDatabase()
            emit(NetworkResult.Success)
        } catch (e: Exception) {
            Timber.d(e.printStackTrace().toString())
            emit(NetworkResult.Failure)
        }
    }

    override suspend fun getDoorsFromDatabaseAsync(): Flow<List<Door>> =
        doorsDao.getDoorsFromDatabaseAsync()
            .toFlow()
            .map { realmResults ->
                doorsDao.getListDoorDboFromRealmResult(realmResults)
                    .map { doorDbo -> doorDbo.toDoor() }
            }

    private suspend fun fetchDoorsAndSaveInDatabase() {
        val getDoorsResponse = doorsNetworkWebservice.getDoors()
        val newDoors = getDoorsResponse.data?.map { doorDto ->
            doorDto.toDoorDbo()
        } ?: emptyList()
        doorsDao.updateDoorsInDatabase(newList = newDoors)
    }

    override suspend fun updateDoor(door: Door) {
        doorsDao.updateDoor(door.toDoorDbo())
    }
}