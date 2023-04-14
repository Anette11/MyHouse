package com.example.domain.di

import com.example.domain.repositories.CamerasRepository
import com.example.domain.use_cases.GetCamerasFromDatabaseUseCaseAsync
import com.example.domain.use_cases.GetInitialCamerasUseCase
import com.example.domain.use_cases.RefreshCamerasUseCase
import com.example.domain.use_cases.UpdateCameraUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CameraUseCasesModule {

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
    ): GetCamerasFromDatabaseUseCaseAsync =
        GetCamerasFromDatabaseUseCaseAsync(repository = repository)

    @Provides
    fun provideUpdateCameraUseCase(
        repository: CamerasRepository
    ): UpdateCameraUseCase = UpdateCameraUseCase(repository = repository)
}