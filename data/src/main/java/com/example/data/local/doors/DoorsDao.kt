package com.example.data.local.doors

import io.realm.Realm
import io.realm.RealmAsyncTask
import io.realm.RealmResults

class DoorsDao(
    private val realm: Realm
) {
    fun updateDoorsInDatabase(
        newList: List<DoorDbo>
    ): RealmAsyncTask = realm.executeTransactionAsync { realm ->
        realm.delete(DoorDbo::class.java)
        realm.insert(newList)
    }

    fun getDoorsFromDatabase(): List<DoorDbo> =
        realm.where(DoorDbo::class.java)
            .findAll()
            .toList()

    fun getDoorsFromDatabaseAsync(): RealmResults<DoorDbo> =
        realm.where(DoorDbo::class.java)
            .findAllAsync()

    fun getListDoorDboFromRealmResult(
        realmResults: RealmResults<DoorDbo>
    ): List<DoorDbo> = realm.copyFromRealm(realmResults)

    fun updateDoor(
        doorDbo: DoorDbo
    ): RealmAsyncTask = realm.executeTransactionAsync { realm ->
        realm.insertOrUpdate(doorDbo)
    }
}