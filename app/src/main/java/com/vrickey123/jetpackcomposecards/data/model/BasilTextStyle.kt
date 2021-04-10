package com.vrickey123.jetpackcomposecards.data.model

import com.squareup.moshi.Json

enum class BasilTextStyle {
    @Json(name = "h5") H5,
    @Json(name = "h5Serif") H5_SERIF,
    @Json(name = "h5SerifLight") H5_SERIF_LIGHT,
    @Json(name = "h5SerifItalic") H5_SERIF_ITALIC,
    @Json(name = "h5SansBold") H5_SANS_BOLD,
    @Json(name = "h6SansBoldInverse") H6_SANS_BOLD_INVERSE,
    @Json(name = "body1") BODY1,
    @Json(name = "body1Serif") BODY1_SERIF,
    @Json(name = "body1Sans") BODY1_SANS,
    @Json(name = "overline") OVERLINE
}