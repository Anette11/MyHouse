package com.example.data.di

import android.util.Log
import com.example.data.remote.NetworkWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
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
                    Log.d(this.javaClass.name, message)
                }
            }
            level = LogLevel.ALL
        }
    }

    @Provides
    @Singleton
    fun provideNetworkWebservice(
        httpClient: HttpClient
    ): NetworkWebservice = NetworkWebservice(httpClient = httpClient)
}