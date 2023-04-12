package com.example.myhouse.ui.screens.cameras

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repositories.CamerasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val repository: CamerasRepository
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCameras()
        }
    }
}