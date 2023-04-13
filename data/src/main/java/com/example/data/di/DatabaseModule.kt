package com.example.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @RealmDbName
    fun provideRealmDbName() = "realm_db"

    @Provides
    @Singleton
    fun provideRealm(
        @ApplicationContext context: Context,
        @RealmDbName realmDbName: String
    ): Realm {
        Realm.init(context)
        val realmConfiguration = RealmConfiguration
            .Builder()
            .name(realmDbName)
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        return Realm.getDefaultInstance()
    }
}