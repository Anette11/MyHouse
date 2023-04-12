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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myhouse.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LargeCardComplex(
    image: Any?,
    name: String,
    isRec: Boolean,
    isFavourite: Boolean
) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .background(colorResource(id = R.color.white)),
    shape = RoundedCornerShape(dimensionResource(id = R.dimen._12dp)),
    elevation = dimensionResource(id = R.dimen._4dp)
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                model = image,
                contentDescription = stringResource(id = R.string.empty),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen._207dp)),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen._207dp))
                    .background(colorResource(id = R.color.saturation))
            ) {}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen._207dp)),
                verticalAlignment = Alignment.Top
            ) {
                if (isRec) {
                    Icon(
                        modifier = Modifier.padding(dimensionResource(id = R.dimen._16dp)),
                        painter = painterResource(id = R.drawable.ic_rec),
                        contentDescription = stringResource(id = R.string.empty),
                        tint = colorResource(id = R.color.red)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                if (isFavourite) {
                    Icon(
                        modifier = Modifier.padding(dimensionResource(id = R.dimen._8dp)),
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = stringResource(id = R.string.empty),
                        tint = colorResource(id = R.color.yellow)
                    )
                }
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = stringResource(id = R.string.empty),
                    tint = colorResource(id = R.color.white)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen._16dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = name,
                fontFamily = FontFamily(Font(R.font.circle_regular)),
                fontSize = dimensionResource(id = R.dimen._17sp).value.sp,
                color = colorResource(id = R.color.gray_darker),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._16dp)))
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_guard_off),
                    contentDescription = stringResource(id = R.string.empty),
                    tint = colorResource(id = R.color.gray_lighter)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LargeCardComplexPreview() =
    LargeCardComplex(
        image = R.drawable.example_picture_2,
        name = stringResource(id = R.string.text_example_camera),
        isRec = true,
        isFavourite = true
    )