package com.ananth.composebasics

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.components.AndroidAlien

@Composable
fun AndroidAliens() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp)
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp)
        )
    }
}