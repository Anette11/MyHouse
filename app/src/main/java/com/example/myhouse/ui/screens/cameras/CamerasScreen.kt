package com.example.myhouse.ui.screens.cameras

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CamerasScreen(
    viewModel: CamerasViewModel = hiltViewModel()
) {
    Text(text = "CamerasScreen")
}