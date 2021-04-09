package com.vrickey123.jetpackcomposecards.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.zIndex
import com.vrickey123.jetpackcomposecards.R
import com.vrickey123.jetpackcomposecards.data.model.TextComponent
import com.vrickey123.jetpackcomposecards.extensions.build
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTypography
import com.vrickey123.jetpackcomposecards.ui.theme.BasilYellowDark
import com.vrickey123.jetpackcomposecards.ui.theme.MaterialInnerHorizontalPadding

@Composable
fun VisualCard(
    title: TextComponent
) {
    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            Color(0xeeeeee),
            Color(0xee000000),
        )
    )
    Card() {
        Box(contentAlignment = Alignment.BottomStart) {
            // 4/3 aspect ratio
            Image(
                modifier = Modifier
                    .aspectRatio(0.75F),
                painter = painterResource(id = R.drawable.bird_green_parrot),
                contentScale = ContentScale.Crop,
                contentDescription = "Green parrot looking at camera on a tree branch"
            )
            Box(modifier = Modifier.background(verticalGradientBrush)
                .matchParentSize()
                .zIndex(2f))
            Text(
                modifier = Modifier.zIndex(3f)
                    .padding(horizontal = MaterialInnerHorizontalPadding),
                text = title.text,
                style = TextStyle.build(title.textStyleKey)
            )
        }
    }
}