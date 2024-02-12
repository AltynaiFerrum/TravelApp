package com.jyldyzferr.travelapp.presentation.screens.auth.sign_in

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.MyTextField
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.LargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.MyBlue1
import com.jyldyzferr.travelapp.presentation.theme.MyBlue3
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import com.jyldyzferr.travelapp.presentation.theme.MyWhite
import com.jyldyzferr.travelapp.presentation.theme.POPPINS
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SignInScreen(
    uiState: SignInUiState,
    onEvent: (SignInEvent) -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToPassword: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isShowInfoBlock by remember { mutableStateOf(false) }

    rememberCoroutineScope().launch() {
        kotlinx.coroutines.delay(100)
        isShowInfoBlock = true
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MyWhite)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(
                id = R.drawable.first_onb_im
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AnimatedVisibility(
            modifier = Modifier,
            visible = isShowInfoBlock,
            enter = fadeIn(
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 1000)
            )
        ) {
            Card(
                modifier = Modifier
                    .padding(top = 280.dp)
                    // .offset(y = -20.dp)
                    .width(460.dp)
                    .height(693.dp),
                shape = RoundedCornerShape(25.dp),
            ) {
                Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 40.dp)) {
                    Text(
                        text = stringResource(id = R.string.getting_started),
                        fontFamily = GILROY,
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = stringResource(id = R.string.lets_login),
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 16.sp,
                            fontFamily = GILROY,
                            color = colorResource(id = R.color.black),
                        ),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    MyTextField(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        isPassword = false,
                        label = "Email Address",
                        value = uiState.email,
                        onValueChange = { value ->
                            onEvent(SignInEvent.OnEmailChanged(value))
                        }
                    )
                    Spacer(modifier = modifier.height(24.dp))
                    MyTextField(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        isPassword = true,
                        label = "Password",
                        value = uiState.password,
                        onValueChange = { value ->
                            onEvent(SignInEvent.OnPasswordChanged(value))
                        }
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    Button(
                        onClick = { onEvent(SignInEvent.OnLoginClick) },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MySignIn
                        )
                    ) {
                        Text(
                            text = "Sign In",
                            fontWeight = FontWeight.Bold,
                            fontFamily = GILROY,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                        )
                    }
                    Spacer(modifier = modifier.height(30.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 35.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.forget_password),
                            fontFamily = POPPINS,
                            fontWeight = FontWeight.Normal,
                            fontSize = 13.sp,
                            color = MyBlue1
                        )
                        Text(
                            modifier = Modifier
                                .clickable { navigateToPassword() },
                            text = stringResource(id = R.string.reset_password),
                            fontFamily = POPPINS,
                            fontWeight = FontWeight.Normal,
                            color = MyBlue3,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 55.dp)
                            .fillMaxSize(),
                    ) {
                        Text(
                            text = stringResource(id = R.string.do_not_have),
                            fontFamily = POPPINS,
                            fontWeight = FontWeight.Normal,
                            fontSize = 13.sp,
                            color = MyBlue1
                        )
                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            modifier = Modifier
                                .clickable { navigateToSignUp() },
                            text = stringResource(id = R.string.sign_up),
                            fontSize = 13.sp,
                            color = MyBlue3,
                            fontFamily = POPPINS,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun LoginTextField(
    text: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(horizontal = LargeSpacing)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(

            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            focusedContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondary,

            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            disabledTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,

            focusedPlaceholderColor = Color.LightGray,
            disabledPlaceholderColor = Color.LightGray,
            unfocusedPlaceholderColor = Color.LightGray,
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = if (isPassword) KeyboardType.Password
            else KeyboardType.Text
        ),

        visualTransformation = if (isPasswordVisible) PasswordVisualTransformation()
        else VisualTransformation.None,
        placeholder = {
            androidx.compose.material.Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        trailingIcon = {
            if (isPassword) {
                val iconId = if (isPasswordVisible) R.drawable.facebook_travel
                else R.drawable.facebook_travel
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }
                )
                {
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = iconId),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                }
            }
        },
        shape = MaterialTheme.shapes.medium
    )
}
