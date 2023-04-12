package com.example.myhouse.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

fun ViewModel.launch(
    dispatcher: CoroutineDispatcher,
    function: suspend () -> Unit
) = viewModelScope.launch(dispatcher) {
    function()
}