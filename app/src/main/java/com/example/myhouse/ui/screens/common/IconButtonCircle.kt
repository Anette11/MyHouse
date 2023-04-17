package com.example.myhouse.ui.screens.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myhouse.R
import com.example.myhouse.ui.theme.BlueSky
import com.example.myhouse.ui.theme.Gray_
import com.example.myhouse.ui.theme.dimens

@Composable
fun IconButtonCircle(
    onClick: () -> Unit,
    @DrawableRes icon: Int,
    tint: Color
) = IconButton(
    onClick = onClick,
    modifier = Modifier
        .size(size = dimens._28dp)
        .border(
            width = dimens._1dp,
            color = Gray_,
            shape = CircleShape
        )
) {
    Icon(
        painterResource(id = icon),
        contentDescription = stringResource(id = R.string.empty),
        tint = tint
    )
}

@Composable
@Preview(showBackground = true)
fun IconButtonCirclePreview() =
    IconButtonCircle(
        onClick = {},
        icon = R.drawable.ic_edit,
        tint = BlueSky
    )