package com.example.myhouse.ui.screens.doors

import androidx.lifecycle.ViewModel
import com.example.data.remote.NetworkWebservice
import com.example.myhouse.di.IODispatcher
import com.example.myhouse.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val networkWebservice: NetworkWebservice,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        launch(ioDispatcher) {
            networkWebservice.getDoors()
        }
    }
}