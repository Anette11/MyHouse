package com.example.data.remote.doors

data class GetDoorsResponse(
    val data: List<DoorDto>?,
    val success: Boolean?
)