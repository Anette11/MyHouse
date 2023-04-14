package com.example.myhouse.ui.screens.doors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.data.di.MainDispatcher
import com.example.domain.data.Door
import com.example.domain.repositories.NetworkResult
import com.example.domain.use_cases.doors.GetDoorsFromDatabaseUseCaseAsync
import com.example.domain.use_cases.doors.GetInitialDoorsUseCase
import com.example.domain.use_cases.doors.RefreshDoorsUseCase
import com.example.domain.use_cases.doors.UpdateDoorUseCase
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
class DoorsViewModel @Inject constructor(
    private val getInitialDoorsUseCase: GetInitialDoorsUseCase,
    private val refreshDoorsUseCase: RefreshDoorsUseCase,
    private val getDoorsFromDatabaseUseCaseAsync: GetDoorsFromDatabaseUseCaseAsync,
    private val updateDoorUseCase: UpdateDoorUseCase,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    private val resourcesProvider: ResourcesProvider
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

    fun refreshDoors() = launch(mainDispatcher) {
        refreshDoorsUseCase.invoke().collectLatest { networkResult ->
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

    fun onClearText() {
        value = resourcesProvider.getString(R.string.empty)
    }

    fun isEnableConfirmButton(): Boolean = value.isNotBlank()

    private fun getDoorsFromDatabaseAsync() = launch(mainDispatcher) {
        getDoorsFromDatabaseUseCaseAsync.invoke().collect { doorsList ->
            val screenItems = buildList {
                doorsList
                    .sortedBy { door -> door.room }
                    .forEach { door ->
                        add(
                            ScreenItem.TitleItem(
                                name = door.room.toStringOrDefault()
                            )
                        )
                        add(
                            door.snapshot?.let {
                                ScreenItem.DoorItem(
                                    image = door.snapshot,
                                    name = door.name.toStringOrDefault(),
                                    status = resourcesProvider.getString(R.string.not_applicable),
                                    isFavourite = door.favorites.toBooleanOrDefault(),
                                    door = door
                                )
                            } ?: ScreenItem.SmallItem(
                                text = door.name.toStringOrDefault(),
                                isFavourite = door.favorites.toBooleanOrDefault(),
                                door = door
                            )
                        )
                    }
            }.distinct()
            this@DoorsViewModel.screenItems = screenItems
        }
    }

    fun updateDoorIsFavourite(door: Door) = launch(mainDispatcher) {
        updateDoorUseCase.invoke(
            door = door.copy(
                favorites = door.favorites?.not() ?: true
            )
        )
    }

    fun updateDoorName() = launch(mainDispatcher) {
        val door = showEditDialog
        door?.let {
            updateDoorUseCase.invoke(
                door = door.copy(
                    name = value.trim()
                )
            )
            hideEditDialog()
        }
    }

    init {
        getDoorsFromDatabaseAsync()

        launch(mainDispatcher) {
            getInitialDoorsUseCase.invoke().collectLatest { networkResult ->
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