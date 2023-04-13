package com.example.data.local.cameras

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class CameraDbo : RealmModel {
    @PrimaryKey
    var dbId: String? = null
    var favorites: Boolean? = null
    var id: Int? = null
    var name: String? = null
    var rec: Boolean? = null
    var room: String? = null
    var snapshot: String? = null
}