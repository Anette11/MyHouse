package com.example.data.di

import com.example.data.repositories.CamerasRepositoryImpl
import com.example.data.repositories.DoorsRepositoryImpl
import com.example.domain.repositories.CamerasRepository
import com.example.domain.repositories.DoorsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindCamerasRepository(
        camerasRepositoryImpl: CamerasRepositoryImpl
    ): CamerasRepository

    @Binds
    abstract fun bindDoorsRepository(
        doorsRepositoryImpl: DoorsRepositoryImpl
    ): DoorsRepository
}