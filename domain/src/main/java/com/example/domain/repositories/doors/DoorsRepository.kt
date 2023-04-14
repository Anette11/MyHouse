package com.example.domain.repositories.doors

import com.example.domain.data.Door

interface DoorsRepository {

    suspend fun getDoors(): List<Door>
}