package com.example.myhouse.ui.screens.doors

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myhouse.R
import com.example.myhouse.ui.screens.common.EditDialog
import com.example.myhouse.ui.screens.common.LargeCardSimple
import com.example.myhouse.ui.screens.common.SmallCard
import com.example.myhouse.ui.screens.util.ScreenItem

@Composable
fun DoorsScreen(
    viewModel: DoorsViewModel = viewModel()
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
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
                            status = status
                        )
                    }
                    is ScreenItem.SmallItem -> SmallCard(
                        text = screenItem.text,
                        onEditClick = { viewModel.showEditDialog(door = screenItem.door) },
                        onFavouriteClick = {
                            Toast.makeText(context, "onFavouriteClick", Toast.LENGTH_SHORT).show()
                        }
                    )
                    else -> Unit
                }
            }
        }
        if (viewModel.showEditDialog != null) {
            EditDialog(
                onValueChange = viewModel::onValueChange,
                onDismiss = viewModel::hideEditDialog,
                onConfirm = viewModel::hideEditDialog,
                value = viewModel.value,
                enableConfirmButton = viewModel.isEnableConfirmButton()
            )
        }
    }
}