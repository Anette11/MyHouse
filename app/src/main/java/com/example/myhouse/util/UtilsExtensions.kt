package com.example.myhouse.util

import android.content.Context
import android.widget.Toast

fun String?.toStringOrDefault(): String = this ?: "n/a"

fun Boolean?.toBooleanOrDefault(): Boolean = this ?: false

fun Context.showToast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()