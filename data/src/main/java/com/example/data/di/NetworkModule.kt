package com.example.data.di

import com.example.data.remote.cameras.CamerasNetworkWebservice
import com.example.data.remote.doors.DoorsNetworkWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Timber.d(message)
                }
            }
            level = LogLevel.ALL
        }
    }

    @Provides
    @Singleton
    fun provideDoorsNetworkWebservice(
        httpClient: HttpClient
    ): DoorsNetworkWebservice = DoorsNetworkWebservice(httpClient = httpClient)

    @Provides
    @Singleton
    fun provideCamerasNetworkWebservice(
        httpClient: HttpClient
    ): CamerasNetworkWebservice = CamerasNetworkWebservice(httpClient = httpClient)
}