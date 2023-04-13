package com.example.myhouse.ui.screens.doors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.data.Door
import com.example.domain.use_cases.GetDoorsUseCase
import com.example.myhouse.R
import com.example.myhouse.di.IODispatcher
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.ResourcesProvider
import com.example.myhouse.util.launch
import com.example.myhouse.util.toStringOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getDoorsUseCase: GetDoorsUseCase,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val resourcesProvider: ResourcesProvider
) : ViewModel() {

    var screenItems by mutableStateOf(emptyList<ScreenItem>())
        private set

    var showEditDialog by mutableStateOf<Door?>(null)
        private set

    fun showEditDialog(door: Door) {
        showEditDialog = door
        onValueChange(door.name ?: resourcesProvider.getString(R.string.empty))
    }

    fun hideEditDialog() {
        showEditDialog = null
    }

    var value by mutableStateOf(resourcesProvider.getString(R.string.empty))
        private set

    fun onValueChange(newValue: String) {
        value = newValue
    }

    fun isEnableConfirmButton(): Boolean = value.isNotBlank()

    private fun getDoors() = launch(ioDispatcher) {
        val doors = getDoorsUseCase.invoke()
        screenItems = doors.map { door ->
            door.snapshot?.let {
                ScreenItem.DoorItem(
                    image = door.snapshot,
                    name = door.name.toStringOrDefault(),
                    status = resourcesProvider.getString(R.string.not_applicable)
                )
            } ?: ScreenItem.SmallItem(
                text = door.name.toStringOrDefault(),
                door = door
            )
        }
    }

    init {
        getDoors()
    }

    var isRefreshing by mutableStateOf(false)
        private set

    fun onRefresh() = launch(ioDispatcher) {
        isRefreshing = true
        delay(3000L)
        isRefreshing = false
    }
}