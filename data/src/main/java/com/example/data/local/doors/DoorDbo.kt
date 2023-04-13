package com.example.data.local.doors

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class DoorDbo : RealmModel {
    @PrimaryKey
    var dbId: String? = null
    var favorites: Boolean? = null
    var id: Int? = null
    var name: String? = null
    var room: String? = null
    var snapshot: String? = null
}