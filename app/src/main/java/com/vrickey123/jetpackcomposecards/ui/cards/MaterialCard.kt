package com.vrickey123.jetpackcomposecards.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import com.vrickey123.jetpackcomposecards.R
import com.vrickey123.jetpackcomposecards.data.model.TextComponent
import com.vrickey123.jetpackcomposecards.extensions.build
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTypography
import com.vrickey123.jetpackcomposecards.ui.theme.MaterialInnerHorizontalPadding
import com.vrickey123.jetpackcomposecards.ui.theme.MaterialInnerVerticalPadding

@Composable
fun MaterialCard(
    overline: TextComponent,
    title: TextComponent,
    body: TextComponent
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            Modifier.padding(
                horizontal = MaterialInnerHorizontalPadding,
                vertical = MaterialInnerVerticalPadding
            )
        ) {
            // 3/2 aspect ratio
            Image(
                modifier = Modifier
                    .aspectRatio(1.5F),
                painter = painterResource(id = R.drawable.bird_of_paradise),
                contentDescription = "Bird of paradise stretching wings on a tree branch",
            )
            Text(text = overline.text, style = TextStyle.build(overline.textStyleKey))
            Text(text = title.text, style = TextStyle.build(title.textStyleKey))
            Text(text = body.text, style = TextStyle.build(body.textStyleKey))
        }
    }
}