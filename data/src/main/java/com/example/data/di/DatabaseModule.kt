package com.example.data.di

import android.content.Context
import com.example.data.BuildConfig
import com.example.data.local.cameras.CamerasDao
import com.example.data.local.doors.DoorsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideRealm(
        @ApplicationContext context: Context
    ): Realm {
        Realm.init(context)
        val realmConfiguration = RealmConfiguration
            .Builder()
            .schemaVersion(BuildConfig.DB_VERSION)
            .name(BuildConfig.DB_NAME)
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        return Realm.getDefaultInstance()
    }

    @Provides
    fun provideCamerasDao(
        realm: Realm
    ): CamerasDao = CamerasDao(realm)

    @Provides
    fun provideDoorsDao(
        realm: Realm
    ): DoorsDao = DoorsDao(realm)
}