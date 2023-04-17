package com.example.myhouse.ui.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.myhouse.R
import com.example.myhouse.ui.theme.*

@Composable
fun EditDialog(
    onValueChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    value: String,
    enableConfirmButton: Boolean,
    onClearText: () -> Unit
) = Dialog(
    onDismissRequest = {}
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(top = dimens._28dp)
                    .fillMaxWidth()
                    .background(
                        color = White,
                        shape = MaterialTheme.shapes.medium
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(height = dimens._36dp))
                Text(
                    text = stringResource(id = R.string.rename_door),
                    style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier.height(height = dimens._21dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimens._16dp),
                    value = value,
                    label = {
                        Text(
                            text = stringResource(id = R.string.edit_dialog_label),
                            fontFamily = CircleRegular
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(id = R.string.empty),
                            tint = GrayLighter,
                            modifier = Modifier.clickable { onClearText() }
                        )
                    },
                    onValueChange = onValueChange,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Black,
                        unfocusedBorderColor = GrayLighter,
                        focusedLabelColor = Black,
                        unfocusedLabelColor = GrayLighter,
                        cursorColor = Black
                    ),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(height = dimens._36dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DialogButton(
                        text = stringResource(id = R.string.cancel),
                        onClick = onDismiss,
                        enable = true
                    )
                    DialogButton(
                        text = stringResource(id = R.string.save),
                        onClick = onConfirm,
                        enable = enableConfirmButton
                    )
                }
                Spacer(modifier = Modifier.height(height = dimens._36dp))
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = stringResource(id = R.string.empty),
                tint = BlueSky,
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .border(
                        width = dimens._2dp,
                        shape = CircleShape,
                        color = BlueSky
                    )
                    .padding(all = dimens._16dp)
                    .align(alignment = Alignment.TopCenter)
            )
        }
    }
}

@Composable
fun DialogButton(
    text: String,
    onClick: () -> Unit,
    enable: Boolean
) = OutlinedButton(
    onClick = onClick,
    border = BorderStroke(
        width = dimens._0dp,
        color = Color.Transparent
    ),
    colors = ButtonDefaults.outlinedButtonColors(
        contentColor = White,
        backgroundColor = if (enable) BlueSky else Gray_
    ),
    enabled = enable
) {
    Text(
        text = text,
        style = MaterialTheme.typography.button
    )
}

@Composable
@Preview(showBackground = true)
fun EditDialogPreview() =
    EditDialog(
        onValueChange = {},
        onDismiss = {},
        onConfirm = {},
        value = stringResource(id = R.string.empty),
        enableConfirmButton = false,
        onClearText = {}
    )