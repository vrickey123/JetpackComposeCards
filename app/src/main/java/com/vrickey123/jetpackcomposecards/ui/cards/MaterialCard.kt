package com.vrickey123.jetpackcomposecards.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import com.vrickey123.jetpackcomposecards.R
import com.vrickey123.jetpackcomposecards.data.model.TextComponent
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTypography

@Composable
fun MaterialCard(
    overline: TextComponent? = null,
    title: TextComponent? = null,
    body: TextComponent? = null
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column() {
            // 3/2 aspect ratio
            Image(
                modifier = Modifier
                    .aspectRatio(1.5F),
                painter = painterResource(id = R.drawable.bird_of_paradise),
                //contentScale = ContentScale.FillBounds,
                contentDescription = "Bird of paradise stretching wings on a tree branch",
            )
            Text(text = "overline", style = MaterialTheme.typography.overline)
            Text(text = "title", style = BasilTypography.h5Serif)
            Text(text = "body", style = BasilTypography.body1Sans)
        }
    }
}