package com.example.myhouse.ui.screens.doors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.NetworkWebservice
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val networkWebservice: NetworkWebservice
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            networkWebservice.getDoors()
        }
    }
}