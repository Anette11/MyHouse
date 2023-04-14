package com.example.data.repositories.doors

import com.example.data.local.doors.DoorsDao
import com.example.data.remote.NetworkWebservice
import com.example.data.remote.doors.toDoor
import com.example.domain.data.Door
import com.example.domain.repositories.doors.DoorsRepository
import timber.log.Timber
import javax.inject.Inject

class DoorsRepositoryImpl @Inject constructor(
    private val networkWebservice: NetworkWebservice,
    private val doorsDao: DoorsDao
) : DoorsRepository {

    override suspend fun getDoors(): List<Door> =
        try {
            val getDoorsResponse = networkWebservice.getDoors()
            getDoorsResponse.data?.map { doorDto ->
                doorDto.toDoor()
            } ?: emptyList()
        } catch (e: Exception) {
            Timber.d(e.localizedMessage)
            emptyList()
        }
}