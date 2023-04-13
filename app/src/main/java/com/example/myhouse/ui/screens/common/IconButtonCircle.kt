package com.example.myhouse.ui.screens.common

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myhouse.R

@Composable
fun IconButtonCircle(
    onClick: () -> Unit,
    @DrawableRes icon: Int,
    @ColorRes tint: Int
) = IconButton(
    onClick = onClick,
    modifier = Modifier
        .size(dimensionResource(id = R.dimen._28dp))
        .border(
            dimensionResource(id = R.dimen._1dp),
            color = colorResource(id = R.color.gray_),
            shape = CircleShape
        )
) {
    Icon(
        painterResource(id = icon),
        contentDescription = stringResource(id = R.string.empty),
        tint = colorResource(id = tint)
    )
}

@Composable
@Preview(showBackground = true)
fun IconButtonCirclePreview() =
    IconButtonCircle(
        onClick = {},
        icon = R.drawable.ic_edit,
        tint = R.color.blue_sky
    )