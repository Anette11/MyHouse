package com.example.domain.di

import com.example.domain.repositories.CamerasRepository
import com.example.domain.repositories.DoorsRepository
import com.example.domain.use_cases.GetCamerasUseCase
import com.example.domain.use_cases.GetDoorsUseCase
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
    ): GetCamerasUseCase = GetCamerasUseCase(repository = repository)

    @Provides
    fun provideGetDoorsUseCase(
        repository: DoorsRepository
    ): GetDoorsUseCase = GetDoorsUseCase(repository = repository)
}