package com.example.myhouse.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myhouse.R
import com.example.myhouse.ui.screens.cameras.CamerasScreen
import com.example.myhouse.ui.screens.common.LargeTitle
import com.example.myhouse.ui.screens.doors.DoorsScreen
import com.example.myhouse.ui.theme.BlueSky
import com.example.myhouse.ui.theme.dimens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) = Column(
    modifier = Modifier.fillMaxSize()
) {
    LargeTitle(text = stringResource(id = R.string.my_house))
    TabRow(
        selectedTabIndex = viewModel.selectedTabIndex,
        backgroundColor = Color.Transparent,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[viewModel.selectedTabIndex]),
                color = BlueSky,
                height = dimens._2dp
            )
        }
    ) {
        viewModel.screens.forEachIndexed { index, screen ->
            val selected = viewModel.selectedTabIndex == index
            Tab(
                selected = selected,
                onClick = { viewModel.onTabSelected(index) }
            ) {
                Text(
                    modifier = Modifier.padding(vertical = dimens._14dp),
                    text = screen.tabName,
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
    HorizontalPager(
        pageCount = viewModel.screens.size,
        userScrollEnabled = false
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            when (viewModel.selectedTabIndex) {
                0 -> CamerasScreen()
                1 -> DoorsScreen()
                else -> Unit
            }
        }
    }
}