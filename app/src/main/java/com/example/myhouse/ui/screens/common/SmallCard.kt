package com.example.myhouse.ui.screens.common

import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.example.myhouse.R
import com.example.myhouse.ui.theme.BlueSky
import com.example.myhouse.ui.theme.Yellow
import com.example.myhouse.ui.theme.dimens
import com.example.myhouse.ui.theme.elevation
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallCard(
    text: String,
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = dimens._21dp,
                            horizontal = dimens._16dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = text,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.width(width = dimens._16dp))
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_lock),
                            contentDescription = stringResource(id = R.string.empty),
                            tint = BlueSky
                        )
                    }
                }
            }
            if (isFavourite) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.padding(
                            top = dimens._16dp,
                            end = dimens._8dp
                        ),
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = stringResource(id = R.string.empty),
                        tint = Yellow
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SmallCardPreview() =
    SmallCard(
        text = stringResource(id = R.string.text_example),
        isFavourite = true,
        onEditClick = {},
        onFavouriteClick = {}
    )