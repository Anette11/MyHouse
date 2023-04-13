package com.example.myhouse.ui.screens.cameras

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.data.di.MainDispatcher
import com.example.data.di.SingleThreadExecutor
import com.example.domain.use_cases.GetCamerasFromDatabaseUseCase
import com.example.domain.use_cases.GetInitialCamerasUseCase
import com.example.domain.use_cases.RefreshCamerasUseCase
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.launch
import com.example.myhouse.util.toBooleanOrDefault
import com.example.myhouse.util.toStringOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getInitialCamerasUseCase: GetInitialCamerasUseCase,
    private val refreshCamerasUseCase: RefreshCamerasUseCase,
    private val getCamerasFromDatabaseUseCase: GetCamerasFromDatabaseUseCase,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    @SingleThreadExecutor private val singleThreadExecutor: CoroutineDispatcher
) : ViewModel() {

    var screenItems by mutableStateOf(emptyList<ScreenItem>())
        private set

    var isRefreshing by mutableStateOf(false)
        private set

    private fun refreshCameras() = launch(singleThreadExecutor) {
        refreshCamerasUseCase.invoke()
        isRefreshing = false
    }

    fun onRefresh() = launch(singleThreadExecutor) {
        isRefreshing = true
        refreshCameras()
    }

    private fun getCamerasFromDatabase() = launch(singleThreadExecutor) {
        getCamerasFromDatabaseUseCase.invoke().collectLatest { cameras ->
            val screenItems = buildList {
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
            withContext(mainDispatcher) {
                this@CamerasViewModel.screenItems = screenItems
            }
        }
    }

    init {
        getCamerasFromDatabase()

        launch(singleThreadExecutor) {
            getInitialCamerasUseCase.invoke()
        }
    }
}