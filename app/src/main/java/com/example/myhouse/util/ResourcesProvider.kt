package com.example.myhouse.util

import androidx.annotation.StringRes

interface ResourcesProvider {

    fun getString(@StringRes stringId: Int): String
}