package com.example.myhouse.ui.screens.cameras

import androidx.lifecycle.ViewModel
import com.example.domain.repositories.CamerasRepository
import com.example.myhouse.di.IODispatcher
import com.example.myhouse.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val repository: CamerasRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        launch(ioDispatcher) {
            repository.getCameras()
        }
    }
}