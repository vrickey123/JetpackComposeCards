package com.vrickey123.jetpackcomposecards.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.zIndex
import com.vrickey123.jetpackcomposecards.R
import com.vrickey123.jetpackcomposecards.data.model.TextComponent
import com.vrickey123.jetpackcomposecards.extensions.build

@Composable
fun VisualCard(
    title: String
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Box(Modifier.fillMaxSize()) {
            // 4/3 aspect ratio
            Image(
                modifier = Modifier
                    .aspectRatio(0.75F),
                painter = painterResource(id = R.drawable.bird_green_parrot),
                //contentScale = ContentScale.FillBounds,
                contentDescription = "Green parrot looking at camera on a tree branch"
            )
            /*Text(modifier = Modifier.zIndex(1F),
                text = title.text,
                style = TextStyle.build(title.textStyleKey))*/
            Text(
                modifier = Modifier.zIndex(1F),
                text = "hello from card"
            )
        }
    }
}