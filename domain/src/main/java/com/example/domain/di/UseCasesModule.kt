package com.example.domain.di

import com.example.domain.repositories.CamerasRepository
import com.example.domain.repositories.DoorsRepository
import com.example.domain.use_cases.GetCamerasFromDatabaseUseCase
import com.example.domain.use_cases.GetDoorsUseCase
import com.example.domain.use_cases.GetInitialCamerasUseCase
import com.example.domain.use_cases.RefreshCamerasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideGetCamerasUseCase(
        repository: CamerasRepository
    ): GetInitialCamerasUseCase = GetInitialCamerasUseCase(repository = repository)

    @Provides
    fun provideRefreshCamerasUseCase(
        repository: CamerasRepository
    ): RefreshCamerasUseCase = RefreshCamerasUseCase(repository = repository)

    @Provides
    fun provideGetCamerasFromDatabaseUseCase(
        repository: CamerasRepository
    ): GetCamerasFromDatabaseUseCase = GetCamerasFromDatabaseUseCase(repository = repository)

    @Provides
    fun provideGetDoorsUseCase(
        repository: DoorsRepository
    ): GetDoorsUseCase = GetDoorsUseCase(repository = repository)
}