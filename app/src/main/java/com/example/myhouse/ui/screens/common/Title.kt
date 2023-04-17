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
fun Title(
    text: String
) = Text(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimens._8dp),
    text = text,
    style = MaterialTheme.typography.h2,
    textAlign = TextAlign.Start
)

@Composable
@Preview(showBackground = true)
fun TitlePreview() =
    Title(text = stringResource(id = R.string.living_room))