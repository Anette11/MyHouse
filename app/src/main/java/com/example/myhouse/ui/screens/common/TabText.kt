package com.example.myhouse.ui.screens.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myhouse.R

@Composable
fun TabText(
    text: String
) = Text(
    text = text,
    fontFamily = FontFamily(Font(R.font.circle)),
    fontSize = dimensionResource(id = R.dimen._17sp).value.sp,
    color = colorResource(id = R.color.gray_dark)
)

@Composable
@Preview(showBackground = true)
fun TabTextPreview() =
    TabText(
        text = stringResource(id = R.string.tab_cameras_name)
    )