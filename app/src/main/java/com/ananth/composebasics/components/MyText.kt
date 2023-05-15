package com.ananth.composebasics.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun MyText(modifier: Modifier = Modifier) {
    var showMore by remember { mutableStateOf(false) }
    //if text goes beyond max lines 6 then we can detect it and show more button

    //annotated string to style parts of text
    Column {
        Text(
            text = "Hello",
            style = MaterialTheme.typography.body1.copy(color = Color.Cyan),
            color = Color.Blue,
            maxLines = 6,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = {
                if (it.hasVisualOverflow) {
                    showMore = true;
                }
            }
        )

        if (showMore) {
            Button(onClick = {}) {
                Text(text = "show more")
            }
        }
    }
}