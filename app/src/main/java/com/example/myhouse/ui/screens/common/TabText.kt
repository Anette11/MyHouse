package com.example.myhouse.ui.screens.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myhouse.R

@Composable
fun TabText(
    text: String
) = Text(
    text = text,
    style = MaterialTheme.typography.h3
)

@Composable
@Preview(showBackground = true)
fun TabTextPreview() =
    TabText(
        text = stringResource(id = R.string.tab_cameras_name)
    )