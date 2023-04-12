package com.example.data.repositories

import com.example.data.remote.NetworkWebservice
import com.example.data.remote.mappers.toDoor
import com.example.domain.data.Door
import com.example.domain.repositories.DoorsRepository
import javax.inject.Inject

class DoorsRepositoryImpl @Inject constructor(
    private val networkWebservice: NetworkWebservice
) : DoorsRepository {

    override suspend fun getDoors(): List<Door> =
        try {
            val getDoorsResponse = networkWebservice.getDoors()
            getDoorsResponse.data?.map { doorDto ->
                doorDto.toDoor()
            } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
}