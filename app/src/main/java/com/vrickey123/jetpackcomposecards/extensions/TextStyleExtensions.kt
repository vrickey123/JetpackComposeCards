package com.vrickey123.jetpackcomposecards.extensions

import androidx.compose.ui.text.TextStyle

fun TextStyle.Companion.build(textStyleKey: String): TextStyle {
/*    when (textStyleKey) {
        "material" -> {
            BasilTypography.h5Serif
            return Jet.isDark
            TextViewCompat.setTextAppearance(titleTextView, R.style.H5)
            bodyTextView?.let { TextViewCompat.setTextAppearance(it, R.style.Body) }
        }
        "light" -> {
            TextViewCompat.setTextAppearance(titleTextView, R.style.H5_Serif_Light)
            bodyTextView?.let { TextViewCompat.setTextAppearance(it, R.style.Body_Sans) }
        }
        "visual" -> {
            TextViewCompat.setTextAppearance(titleTextView, R.style.H6_Sans_Bold_Inverse)
            bodyTextView?.let { TextViewCompat.setTextAppearance(it, R.style.Body_Sans) }
        }
        "typeset" -> {
            TextViewCompat.setTextAppearance(titleTextView, R.style.H5_Serif)
            bodyTextView?.let { TextViewCompat.setTextAppearance(it, R.style.Body_Serif) }
        }
        "header" -> {
            TextViewCompat.setTextAppearance(titleTextView, R.style.H5_Sans_Bold)
            bodyTextView?.let { TextViewCompat.setTextAppearance(it, R.style.Body_Sans) }
        }
        "italic" -> {
            TextViewCompat.setTextAppearance(titleTextView, R.style.H5_SerifItalic)
            bodyTextView?.let { TextViewCompat.setTextAppearance(it, R.style.Body_Serif) }
        }
        else -> {
            TextViewCompat.setTextAppearance(titleTextView, R.style.H5)
            bodyTextView?.let { TextViewCompat.setTextAppearance(it, R.style.Body) }
        }
    }*/
    return TextStyle()
}