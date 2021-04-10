package com.vrickey123.jetpackcomposecards.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.vrickey123.jetpackcomposecards.R
import com.vrickey123.jetpackcomposecards.data.model.TextComponent
import com.vrickey123.jetpackcomposecards.extensions.build
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTypography
import com.vrickey123.jetpackcomposecards.ui.theme.MaterialInnerHorizontalPadding
import com.vrickey123.jetpackcomposecards.ui.theme.MaterialInnerVerticalPadding

@Composable
fun ThumbnailCard(
    overline: TextComponent,
    title: TextComponent,
    body: TextComponent
) {
    Card(Modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(
                horizontal = MaterialInnerHorizontalPadding,
                vertical = MaterialInnerVerticalPadding
            )
        ) {
            Column() {
                Image(
                    modifier = Modifier
                        .height(75.dp)
                        .width(75.dp),
                    painter = painterResource(id = R.drawable.bird_parrots_hugging),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Two green parrots hugging",
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = overline.text, style = TextStyle.build(overline.textStyleKey))
                Text(text = title.text, style = TextStyle.build(title.textStyleKey))
                Text(text = body.text, style = TextStyle.build(body.textStyleKey))
            }
        }
    }
}