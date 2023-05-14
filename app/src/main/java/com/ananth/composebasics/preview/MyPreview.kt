package com.ananth.composebasics.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter

@Composable
fun MyPreview() {
    Column {
        Button(onClick = {}) {
            Text(text = "My Button")
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Column {
        Text(text = message.from)
        Text(text = message.message)
        Text(text = message.date)
    }
}

@Preview
@LocalPreviews
@ThemePreview
@FontScalePreview
@Composable
fun PreviewMyButton() {
    MyPreview()
}


@Preview
@ScreenSpecPreview
@Composable
fun PreviewMessageItem(
    @PreviewParameter(ResourceMessageProvider::class)
    message: Message
) {
    MessageItem(message = message)
}