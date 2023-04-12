package com.example.myhouse.ui.screens.doors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.NetworkWebservice
import com.example.myhouse.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val networkWebservice: NetworkWebservice,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        viewModelScope.launch(ioDispatcher) {
            networkWebservice.getDoors()
        }
    }
}