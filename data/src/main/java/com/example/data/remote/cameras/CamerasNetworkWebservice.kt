package com.example.data.remote.cameras

import com.example.data.BuildConfig
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class CamerasNetworkWebservice(
    private val httpClient: HttpClient
) {
    suspend fun getCameras(): GetCamerasResponse = httpClient
        .get(BuildConfig.BASE_URL.plus(BuildConfig.CAMERAS))
        .body()
}