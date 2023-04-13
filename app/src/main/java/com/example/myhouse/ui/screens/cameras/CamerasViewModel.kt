package com.example.myhouse.ui.screens.cameras

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.GetCamerasUseCase
import com.example.myhouse.di.IODispatcher
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.launch
import com.example.myhouse.util.toBooleanOrDefault
import com.example.myhouse.util.toStringOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getCamerasUseCase: GetCamerasUseCase,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    var screenItems by mutableStateOf(emptyList<ScreenItem>())
        private set

    private fun getCameras() = launch(ioDispatcher) {
        val cameras = getCamerasUseCase.invoke()
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
        isRefreshing = false
    }

    init {
        getCameras()
    }

    var isRefreshing by mutableStateOf(false)
        private set

    fun onRefresh() = launch(ioDispatcher) {
        isRefreshing = true
        getCameras()
    }
}