package com.example.domain.di

import com.example.domain.repositories.doors.DoorsRepository
import com.example.domain.use_cases.*
import com.example.domain.use_cases.doors.GetDoorsFromDatabaseUseCaseAsync
import com.example.domain.use_cases.doors.GetInitialDoorsUseCase
import com.example.domain.use_cases.doors.RefreshDoorsUseCase
import com.example.domain.use_cases.doors.UpdateDoorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DoorUseCasesModule {

    @Provides
    fun provideGetDoorsUseCase(
        repository: DoorsRepository
    ): GetInitialDoorsUseCase = GetInitialDoorsUseCase(repository = repository)

    @Provides
    fun provideRefreshDoorsUseCase(
        repository: DoorsRepository
    ): RefreshDoorsUseCase = RefreshDoorsUseCase(repository = repository)

    @Provides
    fun provideGetDoorsFromDatabaseUseCase(
        repository: DoorsRepository
    ): GetDoorsFromDatabaseUseCaseAsync =
        GetDoorsFromDatabaseUseCaseAsync(repository = repository)

    @Provides
    fun provideUpdateDoorUseCase(
        repository: DoorsRepository
    ): UpdateDoorUseCase = UpdateDoorUseCase(repository = repository)
}