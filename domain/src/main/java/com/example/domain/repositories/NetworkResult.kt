package com.example.domain.repositories

sealed interface NetworkResult {

    object Success : NetworkResult

    object Failure : NetworkResult

    object Loading : NetworkResult
}