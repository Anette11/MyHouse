package com.example.myhouse.ui.screens.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.myhouse.R
import com.example.myhouse.ui.theme.dimens

@Composable
fun LargeTitle(
    text: String
) = Text(
    modifier = Modifier
        .fillMaxWidth()
        .padding(
            top = dimens._29dp,
            bottom = dimens._16dp
        ),
    text = text,
    style = MaterialTheme.typography.h1,
    textAlign = TextAlign.Center
)

@Composable
@Preview(showBackground = true)
fun LargeTitlePreview() =
    LargeTitle(text = stringResource(id = R.string.my_house))