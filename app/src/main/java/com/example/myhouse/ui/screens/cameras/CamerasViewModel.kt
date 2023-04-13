package com.example.myhouse.ui.screens.cameras

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.GetCamerasFromDatabaseUseCase
import com.example.domain.use_cases.GetInitialCamerasUseCase
import com.example.domain.use_cases.RefreshCamerasUseCase
import com.example.myhouse.di.IODispatcher
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.launch
import com.example.myhouse.util.toBooleanOrDefault
import com.example.myhouse.util.toStringOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getInitialCamerasUseCase: GetInitialCamerasUseCase,
    private val refreshCamerasUseCase: RefreshCamerasUseCase,
    private val getCamerasFromDatabaseUseCase: GetCamerasFromDatabaseUseCase,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    var screenItems by mutableStateOf(emptyList<ScreenItem>())
        private set

    var isRefreshing by mutableStateOf(false)
        private set

    private fun refreshCameras() = viewModelScope.launch {
        refreshCamerasUseCase.invoke()
        isRefreshing = false
    }

    fun onRefresh() = viewModelScope.launch {
        isRefreshing = true
        refreshCameras()
    }

    private fun getCamerasFromDatabase() = viewModelScope.launch {
        getCamerasFromDatabaseUseCase.invoke().collectLatest { cameras ->
            screenItems = buildList {
                cameras
                    .sortedBy { camera -> camera.room }
                    .forEach { camera ->
                        add(
                            ScreenItem.TitleItem(
                                name = camera.room.toStringOrDefault()
                            )
                        )
                        add(
                            ScreenItem.CameraItem(
                                image = camera.snapshot,
                                name = camera.name.toStringOrDefault(),
                                isRec = camera.rec.toBooleanOrDefault(),
                                isFavourite = camera.favorites.toBooleanOrDefault()
                            )
                        )
                    }
            }.distinct()
            Timber.d("cameras fetched from database")
        }
    }

    init {
        getCamerasFromDatabase()

        launch(ioDispatcher) {
            getInitialCamerasUseCase.invoke()
        }
    }
}