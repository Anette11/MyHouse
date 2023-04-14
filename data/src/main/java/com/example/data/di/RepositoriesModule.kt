package com.example.data.di

import com.example.data.repositories.cameras.CamerasRepositoryImpl
import com.example.data.repositories.doors.DoorsRepositoryImpl
import com.example.domain.repositories.cameras.CamerasRepository
import com.example.domain.repositories.doors.DoorsRepository
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