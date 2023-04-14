package com.example.myhouse.ui.screens.cameras

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.data.di.MainDispatcher
import com.example.domain.data.Camera
import com.example.domain.repositories.NetworkResult
import com.example.domain.use_cases.cameras.GetCamerasFromDatabaseUseCaseAsync
import com.example.domain.use_cases.cameras.GetInitialCamerasUseCase
import com.example.domain.use_cases.cameras.RefreshCamerasUseCase
import com.example.domain.use_cases.cameras.UpdateCameraUseCase
import com.example.myhouse.R
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.ResourcesProvider
import com.example.myhouse.util.launch
import com.example.myhouse.util.toBooleanOrDefault
import com.example.myhouse.util.toStringOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getInitialCamerasUseCase: GetInitialCamerasUseCase,
    private val refreshCamerasUseCase: RefreshCamerasUseCase,
    private val getCamerasFromDatabaseUseCaseAsync: GetCamerasFromDatabaseUseCaseAsync,
    private val updateCameraUseCase: UpdateCameraUseCase,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    resourcesProvider: ResourcesProvider
) : ViewModel() {

    var screenItems by mutableStateOf(emptyList<ScreenItem>())
        private set

    var isRefreshing by mutableStateOf(false)
        private set

    var isLoading by mutableStateOf(false)
        private set

    private val _isError: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val isError: SharedFlow<Boolean> = _isError

    val defaultErrorText = resourcesProvider.getString(R.string.error_happened)

    fun refreshCameras() = launch(mainDispatcher) {
        refreshCamerasUseCase.invoke().collectLatest { networkResult ->
            when (networkResult) {
                is NetworkResult.Failure -> {
                    isRefreshing = false
                    _isError.emit(true)
                }
                is NetworkResult.Loading -> isRefreshing = true
                is NetworkResult.Success -> isRefreshing = false
            }
        }
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
                                isFavourite = camera.favorites.toBooleanOrDefault(),
                                camera = camera
                            )
                        )
                    }
            }.distinct()
            this@CamerasViewModel.screenItems = screenItems
        }
    }

    fun updateCamera(camera: Camera) = launch(mainDispatcher) {
        updateCameraUseCase.invoke(
            camera = camera.copy(
                favorites = camera.favorites?.not() ?: true
            )
        )
    }

    init {
        getCamerasFromDatabaseAsync()

        launch(mainDispatcher) {
            getInitialCamerasUseCase.invoke().collectLatest { networkResult ->
                when (networkResult) {
                    is NetworkResult.Failure -> {
                        isLoading = false
                        _isError.emit(true)
                    }
                    is NetworkResult.Loading -> isLoading = true
                    is NetworkResult.Success -> isLoading = false
                }
            }
        }
    }
}