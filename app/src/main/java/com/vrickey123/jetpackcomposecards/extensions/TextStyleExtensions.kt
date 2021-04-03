package com.vrickey123.jetpackcomposecards.extensions

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.TextStyle
import androidx.core.widget.TextViewCompat

fun TextStyle.Companion.build(textStyleKey: String): TextStyle {
    when (textStyleKey) {
        "material" -> {
            return MaterialTheme.typography.h5
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
    }
    return TextStyle()
}