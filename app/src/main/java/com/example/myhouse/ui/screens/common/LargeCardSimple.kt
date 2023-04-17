package com.example.myhouse.ui.screens.common

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myhouse.R
import com.example.myhouse.ui.theme.*
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(
    ExperimentalGlideComposeApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun LargeCardSimple(
    image: Any?,
    name: String,
    status: String,
    isFavourite: Boolean,
    onEditClick: () -> Unit,
    onFavouriteClick: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val anchors = mapOf(
        0f to 0,
        (LocalContext.current.resources.displayMetrics.density * 120f).times(-1) to 1
    )

    fun closeCard() = scope.launch {
        swipeableState.animateTo(
            targetValue = 0,
            anim = tween(
                durationMillis = 200,
                delayMillis = 0
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                orientation = Orientation.Horizontal
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButtonCircle(
                onClick = {
                    closeCard()
                    onEditClick()
                },
                icon = R.drawable.ic_edit,
                tint = BlueSky
            )
            Spacer(modifier = Modifier.width(width = dimens._29dp))
            IconButtonCircle(
                onClick = {
                    closeCard()
                    onFavouriteClick()
                },
                icon = if (isFavourite) R.drawable.ic_star_off else R.drawable.ic_star_on,
                tint = Yellow
            )
            Spacer(modifier = Modifier.width(width = dimens._16dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset {
                    IntOffset(
                        x = swipeableState.offset.value.roundToInt(),
                        y = 0
                    )
                }
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimens._8dp),
                elevation = elevation.small
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        GlideImage(
                            model = image,
                            contentDescription = stringResource(id = R.string.empty),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = dimens._207dp),
                            contentScale = ContentScale.Crop
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = dimens._207dp)
                                .background(color = Saturation),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.Top
                        ) {
                            if (isFavourite) {
                                Icon(
                                    modifier = Modifier.padding(all = dimens._8dp),
                                    painter = painterResource(id = R.drawable.ic_star),
                                    contentDescription = stringResource(id = R.string.empty),
                                    tint = Yellow
                                )
                            }
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_play),
                                contentDescription = stringResource(id = R.string.empty),
                                tint = White
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = dimens._16dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = name,
                                style = MaterialTheme.typography.subtitle1,
                                textAlign = TextAlign.Start
                            )
                            Text(
                                text = status,
                                style = MaterialTheme.typography.subtitle2,
                                textAlign = TextAlign.Start
                            )
                        }
                        Spacer(modifier = Modifier.width(width = dimens._16dp))
                        IconButton(onClick = { }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_lock),
                                contentDescription = stringResource(id = R.string.empty),
                                tint = BlueSky
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LargeCardSimplePreview() =
    LargeCardSimple(
        image = R.drawable.example_picture_1,
        name = stringResource(id = R.string.door_phone),
        status = stringResource(id = R.string.online),
        isFavourite = true,
        onFavouriteClick = {},
        onEditClick = {}
    )