package com.example.myhouse.ui.screens.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myhouse.R

@Composable
fun Title(
    text: String
) = Text(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(id = R.dimen._16dp)),
    text = text,
    fontFamily = FontFamily(Font(R.font.circle_light)),
    fontSize = dimensionResource(id = R.dimen._21sp).value.sp,
    color = colorResource(id = R.color.gray_dark),
    textAlign = TextAlign.Start
)

@Composable
@Preview(showBackground = true)
fun TitlePreview() =
    Title(text = stringResource(id = R.string.living_room))