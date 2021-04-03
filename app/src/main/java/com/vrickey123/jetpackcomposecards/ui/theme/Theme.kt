package com.vrickey123.jetpackcomposecards.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

/*private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)*/

private val LightColorPalette = lightColors(
    primary = BasilGreenMid,
    primaryVariant = BasilGreenDark,
    secondary = BasilOrange,
    background = BasilGreenUltraLight,
    surface = BasilYellow,
    onPrimary = BasilOrange,
    onSecondary = BasilGreenDark,
    onBackground = BasilGreenMid,
    onSurface = BasilOrange

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BasilTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    /*val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }*/

    MaterialTheme(
        colors = LightColorPalette,
        typography = BasilTypography.materialTypography,
        shapes = Shapes,
        content = content
    )
}