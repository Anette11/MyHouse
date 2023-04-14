package com.example.myhouse.ui.screens.cameras

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.data.di.MainDispatcher
import com.example.domain.use_cases.GetCamerasFromDatabaseUseCaseAsync
import com.example.domain.use_cases.GetInitialCamerasUseCase
import com.example.domain.use_cases.RefreshCamerasUseCase
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.launch
import com.example.myhouse.util.toBooleanOrDefault
import com.example.myhouse.util.toStringOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getInitialCamerasUseCase: GetInitialCamerasUseCase,
    private val refreshCamerasUseCase: RefreshCamerasUseCase,
    private val getCamerasFromDatabaseUseCaseAsync: GetCamerasFromDatabaseUseCaseAsync,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    var screenItems by mutableStateOf(emptyList<ScreenItem>())
        private set

    var isRefreshing by mutableStateOf(false)
        private set

    private fun refreshCameras() = launch(mainDispatcher) {
        refreshCamerasUseCase.invoke()
        isRefreshing = false
    }

    fun onRefresh() = launch(mainDispatcher) {
        isRefreshing = true
        refreshCameras()
    }

    private fun getCamerasFromDatabaseAsync() = launch(mainDispatcher) {
        getCamerasFromDatabaseUseCaseAsync.invoke().collect { camerasList ->
            val screenItems = buildList {
                camerasList
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
            this@CamerasViewModel.screenItems = screenItems
        }
    }

    init {
        getCamerasFromDatabaseAsync()

        launch(mainDispatcher) {
            getInitialCamerasUseCase.invoke()
        }
    }
}