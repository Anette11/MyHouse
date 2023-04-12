package com.example.myhouse.util

fun String?.toStringOrDefault(): String = this ?: "n/a"

fun Boolean?.toBooleanOrDefault(): Boolean = this ?: false