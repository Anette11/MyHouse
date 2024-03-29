package com.example.myhouse.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourcesProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourcesProvider {

    override fun getString(stringId: Int): String = context.getString(stringId)
}