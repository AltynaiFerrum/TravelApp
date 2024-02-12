package com.jyldyzferr.travelapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.LargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.MediumElevation


@Composable
fun TabBarr(
    title: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        elevation = MediumElevation,
    color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(LargeSpacing)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = GILROY,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
