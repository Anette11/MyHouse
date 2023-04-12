package com.example.myhouse.ui.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myhouse.navigation.Screen

class MainViewModel : ViewModel() {

    var selectedTabIndex by mutableStateOf(0)
        private set

    fun onTabSelected(index: Int) {
        selectedTabIndex = index
    }

    val screens = listOf(
        Screen.Cameras,
        Screen.Doors
    )
}