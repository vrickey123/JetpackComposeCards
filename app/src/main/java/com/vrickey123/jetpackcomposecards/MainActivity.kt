package com.vrickey123.jetpackcomposecards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vrickey123.jetpackcomposecards.data.Serialization
import com.vrickey123.jetpackcomposecards.data.model.Card
import com.vrickey123.jetpackcomposecards.ui.cards.MaterialCard
import com.vrickey123.jetpackcomposecards.ui.cards.ThumbnailCard
import com.vrickey123.jetpackcomposecards.ui.cards.VisualCard
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cards: List<Card> =
            Serialization.getCardsFromAsset(applicationContext, AssetUtil.FILENAME_CARDS)
        setContent {
            BasilTheme {
                // A Surface container using the 'background' color from the app's theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // A Scaffold is used to set Material Layouts like the TopAppBar and Drawer
                    Scaffold(topBar = {
                        TopAppBar {
                            title = stringResource(id = R.string.app_name)
                        }
                    }) {
                        Content(cards = cards)
                    }
                }
            }
        }
    }
}

/**
 * Displays the main content of our app in scrollable list.
 *
 * @param cards A list of Basil Cards that will render our Basil Composable Material,
 * Thumbnail, and Visual UI
 *
 * */
@Composable
fun Content(
    cards: List<Card>
) {
    Column(
        modifier = Modifier.padding(
            horizontal = 16.dp,
            vertical = 16.dp
        )
    ) {
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
                    is Card.Visual -> VisualCard(
                        title = card.title
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
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