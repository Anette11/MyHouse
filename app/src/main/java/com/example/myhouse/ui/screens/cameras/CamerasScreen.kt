package com.example.myhouse.ui.screens.cameras

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myhouse.R
import com.example.myhouse.ui.screens.common.LargeCardComplex
import com.example.myhouse.ui.screens.common.Title
import com.example.myhouse.ui.screens.util.ScreenItem

@Composable
fun CamerasScreen(
    viewModel: CamerasViewModel = viewModel()
) {
    val context = LocalContext.current
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
                        onFavouriteClick = {
                            Toast.makeText(context, "onFavouriteClick", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
                is ScreenItem.TitleItem -> Title(text = screenItem.name)
                else -> Unit
            }
        }
    }
}