package com.example.data.local.cameras

import io.realm.Realm
import io.realm.RealmAsyncTask
import io.realm.RealmResults

class CamerasDao(
    private val realm: Realm
) {
    fun updateCamerasInDatabase(
        newList: List<CameraDbo>
    ): RealmAsyncTask = realm.executeTransactionAsync {
        it.delete(CameraDbo::class.java)
        it.insert(newList)
    }

    fun getCamerasFromDatabase(): List<CameraDbo> =
        realm.where(CameraDbo::class.java)
            .findAll()
            .toList()

    fun getCamerasFromDatabaseAsync(): RealmResults<CameraDbo> =
        realm.where(CameraDbo::class.java)
            .findAllAsync()

    fun getListCameraDboFromRealmResult(
        realmResults: RealmResults<CameraDbo>
    ): List<CameraDbo> = realm.copyFromRealm(realmResults)
}