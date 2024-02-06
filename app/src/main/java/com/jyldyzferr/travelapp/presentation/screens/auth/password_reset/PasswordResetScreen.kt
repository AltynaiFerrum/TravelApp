package com.jyldyzferr.travelapp.presentation.screens.auth.password_reset

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.presentation.components.MyTextField
import com.jyldyzferr.travelapp.presentation.theme.ExtraLargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.LargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import com.jyldyzferr.travelapp.presentation.theme.MyTextField1
import com.jyldyzferr.travelapp.presentation.theme.MyWhite
import com.jyldyzferr.travelapp.presentation.theme.POPPINS


@Composable
fun PasswordResetScreen(
    popBackStack: () -> Unit,
//    viewModel: PasswordResetViewModel = hiltViewModel()
) {
    val context = LocalContext.current
//    val passwordResetData = viewModel.passwordResetData.collectAsState()

//    LaunchedEffect(key1 = viewModel.passwordResetState) {
//        viewModel.passwordResetState.collectLatest {
//            when (it) {
//                is Result.Success -> {
//                    if (it.data) {
//                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
//                        navigator.navigate(SignInScreenDestination)
//                    } else {
//                        Log.d("PasswordResetScreen", "ScreenState: No state received so far.")
//                    }
//                }
//                is Response.Error -> {
//                    Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
//                }
//                is Response.Message -> {
//                    Toast.makeText(context, "Message: ${it.message}", Toast.LENGTH_SHORT).show()
//                }
//                is Response.Loading -> {
//                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }

    Surface(color = MaterialTheme.colors.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = com.jyldyzferr.travelapp.R.drawable.signin_image2),
                contentDescription = "SignUpImage",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight(0.279f)
                    .padding(10.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(MyWhite)
                    .verticalScroll(rememberScrollState())
                    .weight(1f, fill = false)
            ) {
                Text(
                    text = "Reset your password.",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    fontFamily = GILROY,
                    letterSpacing = 1.sp,
                    color = MySignIn,
                    modifier = Modifier.padding(top = 40.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    isPassword = false,
                    label = "Password",
                    value = "",
                    onValueChange = { value ->
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                androidx.compose.material3.Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "The feature is still in development",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(48.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = MySignIn
                    )
                ) {
                    androidx.compose.material3.Text(
                        text = "Reset password",
                        fontFamily = POPPINS,
                        fontWeight = FontWeight.Medium,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.height(250.dp))
                Row(
                    modifier = Modifier
                        .padding(end = 60.dp)
//                    .padding(top = ExtraLargeSpacing)
                        .align(Alignment.End)
                ) {
//                    androidx.compose.material3.Button(
//                        onClick = {
//                            popBackStack()
//                        },
//                        modifier = Modifier
//                            .width(90.dp)
//                            .height(48.dp),
//                        shape = RoundedCornerShape(15.dp),
//                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
//                            containerColor = MyTextField1
//                        )
//                    ) {

                    Icon(
                        modifier = Modifier
                            .size(38.dp),
//                            .clickable { popBackStack() } ,
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = MySignIn
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    androidx.compose.material3.Text(
                        text = "Back",
                        fontSize = 24.sp,
                        fontFamily = POPPINS,
                        color = MySignIn,
                        fontWeight = FontWeight.Medium,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .clickable {
                                popBackStack()
                            }
                    )
                }
            }
        }
    }
}
//}