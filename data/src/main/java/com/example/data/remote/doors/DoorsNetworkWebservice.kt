package com.example.data.remote.doors

import com.example.data.BuildConfig
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class DoorsNetworkWebservice(
    private val httpClient: HttpClient
) {
    suspend fun getDoors(): GetDoorsResponse = httpClient
        .get(BuildConfig.BASE_URL.plus(BuildConfig.DOORS))
        .body()
}