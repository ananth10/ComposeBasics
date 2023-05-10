package com.ananth.composebasics.basic_state

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessApp(modifier: Modifier = Modifier) {
    MaterialTheme() {
        WellnessScreen(modifier)
    }
}


@Preview
@Composable
fun PreviewWellnessApp() {
    MaterialTheme() {
        WellnessApp()
    }
}