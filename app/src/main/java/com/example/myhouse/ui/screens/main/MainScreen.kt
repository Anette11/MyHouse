package com.example.myhouse.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myhouse.R
import com.example.myhouse.ui.screens.cameras.CamerasScreen
import com.example.myhouse.ui.screens.common.LargeTitle
import com.example.myhouse.ui.screens.doors.DoorsScreen

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
                color = colorResource(id = R.color.blue_sky),
                height = dimensionResource(id = R.dimen._2dp)
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
                    modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen._14dp)),
                    text = screen.tabName,
                    fontFamily = FontFamily(Font(R.font.circle_regular)),
                    fontSize = dimensionResource(id = R.dimen._17sp).value.sp,
                    color = colorResource(id = R.color.gray_dark)
                )
            }
        }
    }
    HorizontalPager(
        pageCount = viewModel.screens.size
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