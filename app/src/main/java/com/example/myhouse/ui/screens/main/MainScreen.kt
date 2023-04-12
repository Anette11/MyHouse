package com.example.myhouse.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.myhouse.R
import com.example.myhouse.ui.screens.common.LargeTitle

@Composable
fun MainScreen() =
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LargeTitle(text = stringResource(id = R.string.my_house))
        var selectedIndex by remember { mutableStateOf(0) }
        val tabNames = listOf(
            stringResource(id = R.string.tab_cameras_name),
            stringResource(id = R.string.tab_doors_name)
        )
        TabRow(
            selectedTabIndex = selectedIndex,
            backgroundColor = Color.Transparent,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedIndex]),
                    color = colorResource(id = R.color.blue_sky),
                    height = dimensionResource(id = R.dimen._2dp)
                )
            }
        ) {
            tabNames.forEachIndexed { index, tabName ->
                val selected = selectedIndex == index
                Tab(
                    selected = selected,
                    onClick = { selectedIndex = index }
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen._14dp)),
                        text = tabName,
                        fontFamily = FontFamily(Font(R.font.circle_regular)),
                        fontSize = dimensionResource(id = R.dimen._17sp).value.sp,
                        color = colorResource(id = R.color.gray_dark)
                    )
                }
            }
        }
    }