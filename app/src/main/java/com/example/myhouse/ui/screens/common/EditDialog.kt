package com.example.myhouse.ui.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.myhouse.R

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
                    .padding(top = dimensionResource(id = R.dimen._28dp))
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen._12dp))
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(height = dimensionResource(id = R.dimen._36dp)))
                Text(
                    text = stringResource(id = R.string.rename_door),
                    fontFamily = FontFamily(Font(R.font.circle_regular, FontWeight.Bold)),
                    fontSize = dimensionResource(id = R.dimen._21sp).value.sp
                )
                Spacer(modifier = Modifier.height(height = dimensionResource(id = R.dimen._21dp)))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen._16dp)),
                    value = value,
                    label = {
                        Text(
                            text = stringResource(id = R.string.edit_dialog_label),
                            fontFamily = FontFamily(Font(R.font.circle_regular))
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(id = R.string.empty),
                            tint = colorResource(id = R.color.gray_lighter),
                            modifier = Modifier.clickable { onClearText() }
                        )
                    },
                    onValueChange = onValueChange,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.black),
                        unfocusedBorderColor = colorResource(id = R.color.gray_lighter),
                        focusedLabelColor = colorResource(id = R.color.black),
                        unfocusedLabelColor = colorResource(id = R.color.gray_lighter),
                        cursorColor = colorResource(id = R.color.black)
                    )
                )
                Spacer(modifier = Modifier.height(height = dimensionResource(id = R.dimen._36dp)))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
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
                Spacer(modifier = Modifier.height(height = dimensionResource(id = R.dimen._36dp)))
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = stringResource(id = R.string.empty),
                tint = colorResource(id = R.color.blue_sky),
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .border(
                        width = dimensionResource(id = R.dimen._2dp),
                        shape = CircleShape,
                        color = colorResource(id = R.color.blue_sky)
                    )
                    .padding(all = dimensionResource(id = R.dimen._16dp))
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
        width = dimensionResource(id = R.dimen._0dp),
        color = Color.Transparent
    ),
    shape = RoundedCornerShape(dimensionResource(id = R.dimen._12dp)),
    colors = ButtonDefaults.outlinedButtonColors(
        contentColor = colorResource(id = R.color.white),
        backgroundColor = if (enable) colorResource(id = R.color.blue_sky)
        else colorResource(id = R.color.gray_)
    ),
    enabled = enable
) {
    Text(
        text = text,
        color = colorResource(id = R.color.white),
        fontSize = dimensionResource(id = R.dimen._17sp).value.sp,
        fontFamily = FontFamily(Font(R.font.circle_regular, FontWeight.Bold))
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