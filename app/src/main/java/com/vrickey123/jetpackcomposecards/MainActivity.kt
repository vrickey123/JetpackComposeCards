package com.vrickey123.jetpackcomposecards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vrickey123.jetpackcomposecards.ui.cards.ThumbnailCard
import com.vrickey123.jetpackcomposecards.ui.cards.VisualCard
import com.vrickey123.jetpackcomposecards.ui.theme.BasilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasilTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Column {
                        Text(text = "Hello column!")
                        Card() {
                            Text(text = "Hello card!")
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