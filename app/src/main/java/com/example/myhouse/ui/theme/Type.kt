package com.example.myhouse.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myhouse.R

val CircleLight = FontFamily(
    Font(resId = R.font.circle_light)
)

val CircleRegular = FontFamily(
    Font(resId = R.font.circle_regular)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = CircleRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp,
        color = GrayDark
    ),
    h2 = TextStyle(
        fontFamily = CircleLight,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp,
        color = GrayDark
    ),
    h3 = TextStyle(
        fontFamily = CircleRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        color = GrayDark
    ),
    subtitle1 = TextStyle(
        fontFamily = CircleRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        color = GrayDarker
    ),
    subtitle2 = TextStyle(
        fontFamily = CircleLight,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = GrayLight
    ),
    button = TextStyle(
        fontFamily = CircleRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        color = White
    )
)