package com.company.tictactoe.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val BluePrimary = Color(0xFF2196F3)
val BlueDark = Color(0xFF1976D2)
val RedPrimary = Color(0xFFF44336)
val RedDark = Color(0xFFD32F2F)

val LightColorPalette = lightColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    primaryContainer = BlueDark,
    onPrimaryContainer = Color.White,
    secondary = RedPrimary,
    onSecondary = Color.White,
    secondaryContainer = RedDark,
    onSecondaryContainer = Color.White,
    background = Color(0xFFF5F5F5),
    surface = Color.White,
)