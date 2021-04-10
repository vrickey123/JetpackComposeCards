package com.vrickey123.jetpackcomposecards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vrickey123.jetpackcomposecards.data.Serialization
import com.vrickey123.jetpackcomposecards.data.model.Card
import com.vrickey123.jetpackcomposecards.ui.cards.MaterialCard
import com.vrickey123.jetpackcomposecards.ui.cards.ThumbnailCard
import com.vrickey123.jetpackcomposecards.ui.cards.VisualCard
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cards: List<Card> = Serialization.getCardsFromAsset(applicationContext, AssetUtil.FILENAME_CARDS)
        setContent {
            BasilTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Column {
                        LazyColumn() {
                            items(cards) { card ->
                                when (card) {
                                    is Card.Material -> MaterialCard(
                                        overline = card.overline,
                                        title = card.title,
                                        body = card.body
                                    )
                                    is Card.Thumbnail -> ThumbnailCard(
                                        overline = card.overline,
                                        title = card.title,
                                        body = card.body
                                    )
                                    is Card.Visual -> VisualCard(title = card.title)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasilTheme {
        Card() {
            Text(text = "Hello card!")
        }
    }
}