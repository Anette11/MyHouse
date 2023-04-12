package com.example.myhouse.ui.screens.doors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.GetDoorsUseCase
import com.example.myhouse.di.IODispatcher
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.launch
import com.example.myhouse.util.toStringOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getDoorsUseCase: GetDoorsUseCase,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    var screenItems by mutableStateOf(emptyList<ScreenItem>())
        private set

    private fun getDoors() = launch(ioDispatcher) {
        val doors = getDoorsUseCase.invoke()
        screenItems = doors.map { door ->
            door.snapshot?.let {
                ScreenItem.DoorItem(
                    image = door.snapshot,
                    name = door.name.toStringOrDefault(),
                    status = "n/a"
                )
            } ?: ScreenItem.SmallItem(
                text = door.name.toStringOrDefault()
            )
        }
    }

    init {
        getDoors()
    }
}