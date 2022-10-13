package com.jmc.utils

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jmc.theme.BlackBrown
import com.jmc.theme.WetAsphalt

val Colors.textField: Color
    @Composable get() = if (isLight) Color.White else BlackBrown

val Colors.textFieldOnSurface: Color
    @Composable get() = if (isLight) WetAsphalt else Color.White