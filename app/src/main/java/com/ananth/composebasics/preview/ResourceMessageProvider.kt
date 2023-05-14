package com.ananth.composebasics.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ResourceMessageProvider : PreviewParameterProvider<Message> {
    override val values = sequenceOf(
        Message("Hello", "10.05.23", "John")
    )
}