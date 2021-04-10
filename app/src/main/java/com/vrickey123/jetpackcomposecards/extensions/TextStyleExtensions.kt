package com.vrickey123.jetpackcomposecards.extensions

import androidx.compose.ui.text.TextStyle
import com.vrickey123.jetpackcomposecards.data.model.BasilTextStyle
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTypography
import com.vrickey123.jetpackcomposecards.ui.theme.Typography

fun TextStyle.Companion.build(
    textStyleKey: BasilTextStyle
): TextStyle {
    return when (textStyleKey) {
        BasilTextStyle.H5 -> BasilTypography.materialTypography.h5
        BasilTextStyle.H5_SERIF -> BasilTypography.h5Serif
        BasilTextStyle.H5_SERIF_LIGHT -> BasilTypography.h5SerifLight
        BasilTextStyle.H5_SERIF_ITALIC -> BasilTypography.h5SerifItalic
        BasilTextStyle.H5_SANS_BOLD -> BasilTypography.h6SansBold
        BasilTextStyle.H6_SANS_BOLD_INVERSE -> BasilTypography.h6SansBoldInverse
        BasilTextStyle.BODY1 -> BasilTypography.materialTypography.body1
        BasilTextStyle.BODY1_SERIF -> BasilTypography.body1Serif
        BasilTextStyle.BODY1_SANS -> BasilTypography.body1Sans
        BasilTextStyle.OVERLINE -> Typography.overline
    }
}