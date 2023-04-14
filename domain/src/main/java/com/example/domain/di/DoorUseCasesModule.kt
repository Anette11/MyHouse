package com.example.domain.di

import com.example.domain.repositories.DoorsRepository
import com.example.domain.use_cases.*
import com.example.domain.use_cases.doors.GetDoorsUseCase
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
    ): GetDoorsUseCase = GetDoorsUseCase(repository = repository)
}