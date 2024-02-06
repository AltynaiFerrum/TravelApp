package com.jyldyzferr.travelapp.presentation.screens.auth.sign_up

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.MyTextField
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MyBlue1
import com.jyldyzferr.travelapp.presentation.theme.MyBlue3
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import com.jyldyzferr.travelapp.presentation.theme.MyWhite
import com.jyldyzferr.travelapp.presentation.theme.POPPINS

@Composable
fun SignUpScreen(
    popBackStack: () -> Unit,
    uiState: SignUpUiState,
    onEvent: (SignUpEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
//            .background(MyWhite)
    ) {
        Image(
            painter = painterResource(id = R.drawable.create_acc),
            contentDescription = "Header background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, -(30).dp)
        )
//        Image(
//            modifier = Modifier
//                .fillMaxSize(),
//            painter = painterResource(
//                id = R.drawable.back_onboarding
//            ),
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
        Column (
            modifier = Modifier
        ){
            Icon( 
                modifier = Modifier
                    .padding(
                        top = 70.dp,
                        start = 20.dp
                    )
                    .size(38.dp)
                    .clickable { popBackStack() } ,
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.White
            )
            Column(
                modifier = Modifier
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 60.dp
                    )
            ) {
                    Text( modifier = Modifier
                        .padding(
                            horizontal = 65.dp
                        ),
                        text = stringResource(id = R.string.create_account),
                        fontFamily = GILROY,
                        color = MySignIn,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge
                    )
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = 65.dp
                        ),
                    text = stringResource(id = R.string.account),
                    fontFamily = GILROY,
                    color = MySignIn,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = modifier.height(40.dp))
                MyTextField(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .fillMaxWidth(1f),
                    isPassword = false,
                    label = "Name",
                    value = uiState.name,
                    onValueChange = {
                        onEvent(SignUpEvent.OnNameChanged(it))                    }
                )
//                OutlinedTextFieldTravelName(
//                    text = uiState.name,
//                    onValueChange = {
//                        onEvent(SignUpEvent.OnNameChanged(it))
//                    },
//                )
                Spacer(modifier = modifier.height(24.dp))
                MyTextField(
                    modifier = Modifier
//                        .background(Color.Transparent)
                        .fillMaxWidth(1f),
                    isPassword = false,
                    label = "Last Name",
                    value = uiState.lastName,
                    onValueChange = {
                        onEvent(SignUpEvent.OnLastNameChanged(it))
                    }
                )
//                OutlinedTextFieldTravelLastName(
//                    text = uiState.lastName,
//                    onValueChange = {
//                        onEvent(SignUpEvent.OnLastNameChanged(it))
//                    },
//                )
                Spacer(modifier = modifier.height(24.dp))
                MyTextField(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    isPassword = false,
                    label = "Email",
                    value = uiState.email,
                    onValueChange = {
                        onEvent(SignUpEvent.OnEmailChanged(it))
                    }
                )
//                OutlinedTextFieldTravelEmail(
//                    text = uiState.email,
//                    onValueChange = {
//                        onEvent(SignUpEvent.OnEmailChanged(it))
//                    },
//                )
                Spacer(modifier = modifier.height(24.dp))
                MyTextField(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    isPassword = true,
                    label = "Password",
                    value = uiState.password,
                    onValueChange = {
                        onEvent(SignUpEvent.OnPasswordChanged(it))
                    },
                )
//                OutlinedTextFieldTravelPassword(
//                    text = uiState.password,
//                    onValueChange = {
//                        onEvent(SignUpEvent.OnPasswordChanged(it))
//                    },
//                    isPassword = true
//                )
                Spacer(modifier = modifier.height(40.dp))
                Button(
                    onClick = {
                        onEvent(SignUpEvent.OnLoginClick)
                              },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(48.dp),
//                        .padding(horizontal = 14.dp)
//                        .width(327.dp)
//                        .height(48.dp)
//                        .clip(RoundedCornerShape(24.dp)),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MySignIn
                    )
                ) {
                    Text(
                        text = "Register",
                        fontFamily = GILROY,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                    )
                }
                Spacer(modifier = modifier.height(20.dp))
//            Row(
//                modifier = Modifier
//                    .padding(horizontal = 55.dp)
//            ) {
//                Divider(
//                    color = MyBlue1,
//                    modifier = Modifier
//                        .width(66.dp)
//                        .height(1.dp)
//                )
//                Spacer(modifier = Modifier.width(4.dp))
//                Text(
//                    modifier = Modifier
//                        .padding(start = 0.dp)
//                        .padding(bottom = 5.dp),
//                    text = "Or continue with",
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight.Normal,
//                    style = MaterialTheme.typography.bodySmall,
//                    color = MyBlue1
//                )
//                Spacer(modifier = Modifier.width(4.dp))
//                Divider(
//                    color = MyBlue1,
//                    modifier = Modifier
//                        .width(66.dp)
//                        .height(1.dp)
//                )
//            }
//            Row(
//                modifier = Modifier
//            ) {
//                Image(
//                    modifier = modifier
//                        .width(120.dp)
//                        .height(28.dp),
//                    painter = painterResource(id = R.drawable.facebook_travel),
//                    contentDescription = null,
//                )
//                Image(
//                    modifier = modifier
//                        .width(120.dp)
//                        .height(28.dp),
//                    painter = painterResource(id = R.drawable.google_travel),
//                    contentDescription = null,
//                )
//                Image(
//                    modifier = modifier
//                        .width(120.dp)
//                        .height(28.dp),
//                    painter = painterResource(id = R.drawable.mac_travel),
//                    contentDescription = null,
//                )
//            }
                Row(
                    modifier = Modifier
                        .padding(start = 55.dp)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = stringResource(id = R.string.already_have),
                        fontFamily = POPPINS,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = MyBlue1
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        modifier = Modifier
                            .clickable {onEvent(SignUpEvent.OnLoginClick) },
                        text = "Sign In",
                        color = MyBlue3,
                        fontFamily = GILROY,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}
