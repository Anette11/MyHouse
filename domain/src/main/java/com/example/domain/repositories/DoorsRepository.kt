package com.example.domain.repositories

import com.example.domain.data.Door

interface DoorsRepository {

    suspend fun getDoors(): List<Door>
}