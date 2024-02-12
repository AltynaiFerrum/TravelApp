package com.jyldyzferr.travelapp.presentation.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jyldyzferr.travelapp.presentation.components.AnimatedPreloader
import kotlinx.coroutines.delay

private const val SPLASH_SCREEN_SHOW_TIME = 3000L

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(key1 = Unit) {
        delay(SPLASH_SCREEN_SHOW_TIME)
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        AnimatedPreloader(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
        )
    }
}


