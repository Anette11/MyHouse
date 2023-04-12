package com.example.myhouse.di

import com.example.myhouse.util.ResourcesProvider
import com.example.myhouse.util.ResourcesProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ResourcesProviderModule {

    @Binds
    abstract fun bindResourcesProvider(
        resourcesProviderImpl: ResourcesProviderImpl
    ): ResourcesProvider
}