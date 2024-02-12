package com.jyldyzferr.travelapp.presentation.screens.info

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MyBlue5
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
    text: String, context: Context
) {
    var isShowInfoBlock by remember { mutableStateOf(false) }

    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)

    rememberCoroutineScope().launch() {
        kotlinx.coroutines.delay(500)
        isShowInfoBlock = true
    }

    Surface(color = MaterialTheme.colorScheme.background) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.signin_image2),
                contentDescription = "SignUpImage",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight(0.279f)
                    .padding(10.dp)
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .verticalScroll(rememberScrollState())
                        .weight(1f, fill = false)
                ) {
                    Text(
                        text = stringResource(id = R.string.info_details),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        fontFamily = GILROY,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .padding(horizontal = 50.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            startActivity(context, shareIntent, null)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(48.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSystemInDarkTheme()) MySignIn
                            else MyBlue5
                        )
                    )
                    {
                        Text(
                            text = "Whats App",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontFamily = GILROY,
                            fontWeight = FontWeight.Bold,
                            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            startActivity(context, shareIntent, null)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(48.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSystemInDarkTheme()) MySignIn
                            else MyBlue5
                        )
                    ) {
                        Text(
                            text = "Instagram",
                            fontWeight = FontWeight.Bold,
                            fontFamily = GILROY,
                            color = MaterialTheme.colorScheme.onBackground,
                            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            startActivity(context, shareIntent, null)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(48.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSystemInDarkTheme()) MySignIn
                            else MyBlue5
                        )
                    ) {
                        Text(
                            text = "Share",
                            fontFamily = GILROY,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Share(
    modifier: Modifier = Modifier,
    text: String, context: Context
) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)


    Button(onClick = {
        startActivity(context, shareIntent, null)
    }) {
        Icon(imageVector = Icons.Default.Share, contentDescription = null)
        Text("Share", modifier = Modifier.padding(start = 8.dp))
    }
}