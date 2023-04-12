package com.example.data.remote.doors

data class GetDoorsResponse(
    val data: List<DataDto>?,
    val success: Boolean?
)