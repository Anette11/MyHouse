package com.example.domain.repositories

sealed interface NetworkResult<T> {

    data class Success<T>(val list: List<T>) : NetworkResult<T>

    class Failure<T> : NetworkResult<T>

    class Loading<T> : NetworkResult<T>
}