package com.vrickey123.jetpackcomposecards.extensions

import androidx.compose.ui.text.TextStyle
import com.vrickey123.jetpackcomposecards.data.model.BasilTextStyle
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTypography

fun TextStyle.Companion.build(
    textStyleKey: BasilTextStyle
): TextStyle {
    return when (textStyleKey) {
        BasilTextStyle.H5 -> return BasilTypography.materialTypography.h5
        BasilTextStyle.H5_SERIF -> return BasilTypography.h5Serif
        BasilTextStyle.H5_SERIF_LIGHT -> return BasilTypography.h5SerifLight
        BasilTextStyle.H5_SERIF_ITALIC -> return BasilTypography.h5SerifItalic
        BasilTextStyle.H5_SANS_BOLD -> return BasilTypography.h6SansBold
        BasilTextStyle.H6_SANS_BOLD_INVERSE -> return BasilTypography.h6SansBoldInverse
        BasilTextStyle.BODY1 -> return BasilTypography.materialTypography.body1
        BasilTextStyle.BODY1_SERIF -> BasilTypography.body1Serif
        BasilTextStyle.BODY1_SANS -> BasilTypography.body1Sans
    }
}