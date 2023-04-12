package com.example.myhouse.ui.screens.doors

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhouse.ui.screens.common.LargeCardSimple
import com.example.myhouse.ui.screens.common.SmallCard
import com.example.myhouse.ui.screens.util.ScreenItem

@Composable
fun DoorsScreen(
    viewModel: DoorsViewModel = hiltViewModel()
) = LazyColumn(
    modifier = Modifier.fillMaxWidth()
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
            is ScreenItem.SmallItem -> SmallCard(text = screenItem.text)
            else -> Unit
        }
    }
}