package com.example.myhouse.ui.screens.doors

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myhouse.R
import com.example.myhouse.ui.screens.common.EditDialog
import com.example.myhouse.ui.screens.common.LargeCardSimple
import com.example.myhouse.ui.screens.common.SmallCard
import com.example.myhouse.ui.screens.common.Title
import com.example.myhouse.ui.screens.util.ScreenItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DoorsScreen(
    viewModel: DoorsViewModel = viewModel()
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = viewModel.isRefreshing,
        onRefresh = viewModel::onRefresh
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(state = pullRefreshState),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen._21dp))
        ) {
            items(viewModel.screenItems) { screenItem ->
                when (screenItem) {
                    is ScreenItem.DoorItem -> with(screenItem) {
                        LargeCardSimple(
                            image = image,
                            name = name,
                            status = status,
                            isFavourite = isFavourite,
                            onEditClick = { viewModel.showEditDialog(door = door) },
                            onFavouriteClick = { viewModel.updateDoorIsFavourite(door = door) }
                        )
                    }
                    is ScreenItem.SmallItem -> with(screenItem) {
                        SmallCard(
                            text = text,
                            isFavourite = isFavourite,
                            onEditClick = { viewModel.showEditDialog(door = door) },
                            onFavouriteClick = { viewModel.updateDoorIsFavourite(door = door) }
                        )
                    }
                    is ScreenItem.TitleItem -> Title(text = screenItem.name)
                    else -> Unit
                }
            }
        }
        if (viewModel.showEditDialog != null) {
            EditDialog(
                onValueChange = viewModel::onValueChange,
                onDismiss = viewModel::hideEditDialog,
                onConfirm = viewModel::updateDoorName,
                value = viewModel.value,
                enableConfirmButton = viewModel.isEnableConfirmButton(),
                onClearText = viewModel::onClearText
            )
        }
        PullRefreshIndicator(
            refreshing = viewModel.isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            contentColor = colorResource(id = R.color.blue_sky)
        )
    }
}