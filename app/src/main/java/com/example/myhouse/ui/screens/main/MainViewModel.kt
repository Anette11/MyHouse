package com.example.myhouse.ui.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.di.DefaultDispatcher
import com.example.myhouse.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    var selectedTabIndex by mutableStateOf(0)
        private set

    fun onTabSelected(index: Int) {
        selectedTabIndex = index
        viewModelScope.launch(defaultDispatcher) {
            _navigateToRoute.emit(screens[index].route)
        }
    }

    private val _navigateToRoute: MutableSharedFlow<String> = MutableSharedFlow()
    val navigateToRoute: SharedFlow<String> = _navigateToRoute.asSharedFlow()

    val screens = listOf(
        Screen.Cameras,
        Screen.Doors
    )
}