package com.jmc.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColors(
    primary = Color.White,
    onPrimary = Color.Black,
    secondary = ShinyOrange,
    onSecondary = Color.White,
    background = SmokyWhite,
    surface = SmokyWhite,
    onBackground = WetAsphalt,
    onSurface = WetAsphalt
)

private val DarkColors = darkColors(
    primary = Color.Black,
    onPrimary = Color.White,
    secondary = ShinyOrange,
    onSecondary = Color.Black,
    background = Color.Black,
    surface = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun PaymentAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}