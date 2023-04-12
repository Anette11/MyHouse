package com.example.myhouse.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myhouse.R

@Composable
fun SmallCard(
    text: String
) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(id = R.dimen._8dp))
        .background(colorResource(id = R.color.white)),
    shape = RoundedCornerShape(dimensionResource(id = R.dimen._12dp)),
    elevation = dimensionResource(id = R.dimen._4dp)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = dimensionResource(id = R.dimen._21dp),
                horizontal = dimensionResource(id = R.dimen._16dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            fontFamily = FontFamily(Font(R.font.circle_regular)),
            fontSize = dimensionResource(id = R.dimen._17sp).value.sp,
            color = colorResource(id = R.color.gray_darker)
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._16dp)))
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = stringResource(id = R.string.empty),
                tint = colorResource(id = R.color.blue_sky)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SmallCardPreview() =
    SmallCard(
        text = stringResource(id = R.string.text_example)
    )