package com.vrickey123.jetpackcomposecards.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vrickey123.jetpackcomposecards.ui.theme.typography.font.Merriweather
import com.vrickey123.jetpackcomposecards.ui.theme.typography.font.QuattroCentoSans

// Set of Material typography styles to start with
private val Typography = Typography(
    defaultFontFamily = Merriweather,
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val BasilTypography = BasilType()

// Custom Text Styles that extend from Material Typography (by using copy function)
@Immutable
data class BasilType(
    val materialTypography: Typography = Typography,
    val h5SerifLight: TextStyle = Typography.h5.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal
    ),
    val h5SerifLightItalic: TextStyle = Typography.h5.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic
    ),
    val h5Serif: TextStyle = Typography.h5.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = BasilOrange
    ),
    val h5SerifItalic: TextStyle = Typography.h5.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic
    ),
    val h5Sans: TextStyle = Typography.h5.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    val h5SansItalic: TextStyle = Typography.h5.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic
    ),
    val h5SansBold: TextStyle = Typography.h5.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal
    ),
    val h6SerifLight: TextStyle = Typography.h6.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal
    ),
    val h6SerifLightItalic: TextStyle = Typography.h6.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic
    ),
    val h6Serif: TextStyle = Typography.h6.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    val h6SerifInverse: TextStyle = Typography.h6.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = BasilYellow
    ),
    val h6SerifItalic: TextStyle = Typography.h6.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic
    ),
    val h6Sans: TextStyle = Typography.h6.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    val h6SansItalic: TextStyle = Typography.h6.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic
    ),
    val h6SansBold: TextStyle = Typography.h6.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal
    ),
    val h6SansBoldInverse: TextStyle = Typography.h6.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        color = BasilYellow
    ),
    val body1Inverse: TextStyle = Typography.body1.copy(
        color = Color.White
    ),
    val body1Sans: TextStyle = Typography.body1.copy(
        fontFamily = QuattroCentoSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    val body1Serif: TextStyle = Typography.body1.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
)