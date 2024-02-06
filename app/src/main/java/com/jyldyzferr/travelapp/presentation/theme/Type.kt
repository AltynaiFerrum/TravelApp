package com.jyldyzferr.travelapp.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.R
val MUSEO_MODERNO = FontFamily(
    Font(R.font.museo_moderno_regular, FontWeight.Normal),
    Font(R.font.museo_moderno_medium, FontWeight.Medium),
    Font(R.font.museo_moderno_bold, FontWeight.Bold),
    Font(R.font.museo_moderno_thin, FontWeight.Thin),
    Font(R.font.museo_moderno_semibold, FontWeight.SemiBold),
    Font(R.font.museo_moderno_light, FontWeight.Light)
)

val GILROY = FontFamily(
    Font(R.font.gilroy_regular, FontWeight.Normal),
    Font(R.font.gilroy_bold, FontWeight.Bold),
)

val POPPINS = FontFamily(
    Font(R.font.poppins, FontWeight.Normal),
    )

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
    ),
    headlineMedium = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 26.sp,
        fontWeight = FontWeight.Normal
    ),
    headlineSmall = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    titleLarge = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal
    ),
    titleSmall = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light
    ),
    bodyMedium = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    ),
    bodySmall = TextStyle(
        fontFamily = MUSEO_MODERNO,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light
    )
)
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
