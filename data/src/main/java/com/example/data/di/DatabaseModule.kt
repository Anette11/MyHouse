package com.example.data.di

import android.content.Context
import com.example.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.runBlocking
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRealm(
        @ApplicationContext context: Context,
        @SingleThreadExecutor singleThreadExecutor: CoroutineDispatcher
    ): Realm = runBlocking(singleThreadExecutor) {
        Realm.init(context)
        val realmConfiguration = RealmConfiguration
            .Builder()
            .schemaVersion(BuildConfig.DB_VERSION)
            .name(BuildConfig.DB_NAME)
            .build()
        Realm.getInstance(realmConfiguration)
    }
}