package com.ananth.composebasics.insets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//insets describe how much the content of your app needs to be padded to avoid overlapping with
//parts of the system UI or physical device features.

//for manual controlling insets do below changes,

//step1: add this in Activity         WindowCompat.setDecorFitsSystemWindows(window,false)
//step 2: Add this Activity in manifest             android:windowSoftInputMode="adjustResize"
//step 3: Make statusBar and navigation bar colors in theme.xml file
@Composable
fun MyInsets(modifier: Modifier = Modifier) {
    var textFieldValue by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp)
                    .background(Color.White)
            )

            TextField(
                value = textFieldValue,
                onValueChange = { value -> textFieldValue = value },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .imePadding() // so keypad will stick to bottom of text field box
            )
        }
    }
}