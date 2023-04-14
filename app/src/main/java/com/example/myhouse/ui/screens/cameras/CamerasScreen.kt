package com.example.myhouse.ui.screens.cameras

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myhouse.R
import com.example.myhouse.ui.screens.common.LargeCardComplex
import com.example.myhouse.ui.screens.common.Title
import com.example.myhouse.ui.screens.util.ScreenItem
import com.example.myhouse.util.showToast
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CamerasScreen(
    viewModel: CamerasViewModel = viewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.isError.collectLatest { boolean ->
            if (boolean) context.showToast(message = viewModel.defaultErrorText)
        }
    }

    val pullRefreshState = rememberPullRefreshState(
        refreshing = viewModel.isRefreshing,
        onRefresh = viewModel::refreshCameras
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
                    is ScreenItem.CameraItem -> with(screenItem) {
                        LargeCardComplex(
                            image = image,
                            name = name,
                            isRec = isRec,
                            isFavourite = isFavourite,
                            onFavouriteClick = { viewModel.updateCamera(camera = camera) }
                        )
                    }
                    is ScreenItem.TitleItem -> Title(text = screenItem.name)
                    else -> Unit
                }
            }
        }
        PullRefreshIndicator(
            refreshing = viewModel.isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            contentColor = colorResource(id = R.color.blue_sky)
        )

        if (viewModel.isLoading) {
            CircularProgressIndicator(color = colorResource(id = R.color.blue_sky))
        }
    }
}