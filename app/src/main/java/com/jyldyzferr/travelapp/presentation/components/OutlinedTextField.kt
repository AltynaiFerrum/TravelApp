package com.jyldyzferr.travelapp.presentation.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MySignIn

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    isPassword: Boolean,
    label: String,
    placeholder: String = "",
    value: String,
    onValueChange: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var isInputVisible by remember {
        if (isPassword) mutableStateOf(false) else mutableStateOf(true)
    }

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = {
                    isInputVisible = !isInputVisible
                }) {
                    androidx.compose.material.Icon(
                        painter = painterResource(id = R.drawable.ic_password_eye),
                        contentDescription = null,
                        tint = if (isInputVisible) androidx.compose.material.MaterialTheme.colors.primary else Color.Gray
                    )
                }
            }
        },
        label = {
            androidx.compose.material.Text(
                text = label,
                fontFamily = GILROY
            )
        },
        placeholder = {
            androidx.compose.material.Text(
                text = placeholder,
                fontFamily = GILROY
            )
        },
        singleLine = true,
        visualTransformation = if (isInputVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = modifier,
        keyboardOptions = if (isInputVisible) KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ) else KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                keyboardController?.hide()
            },
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = MySignIn,
            unfocusedIndicatorColor = MySignIn,
            cursorColor = Color.Transparent,
        ),
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun OutlinedTextFieldPreview() {
    MaterialTheme {
        OutlinedTextField(
            value = "",
            onValueChange = {},
        )
    }
}