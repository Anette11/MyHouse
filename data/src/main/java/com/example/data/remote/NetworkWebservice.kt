package com.example.data.remote

import com.example.data.BuildConfig
import com.example.data.remote.cameras.GetCamerasResponse
import com.example.data.remote.doors.GetDoorsResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class NetworkWebservice(
    private val httpClient: HttpClient
) {
    suspend fun getCameras(): GetCamerasResponse = httpClient
        .get(BuildConfig.BASE_URL.plus(BuildConfig.CAMERAS))
        .body()

    suspend fun getDoors(): GetDoorsResponse = httpClient
        .get(BuildConfig.BASE_URL.plus(BuildConfig.DOORS))
        .body()
}