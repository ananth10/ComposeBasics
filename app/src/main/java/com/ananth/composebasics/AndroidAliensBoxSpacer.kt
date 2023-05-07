package com.ananth.composebasics

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.components.AndroidAlien

@Composable
fun AndroidAliensWithBoxSpacer() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
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

        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(color = Color.Gray.copy(alpha = .7f))
        )
        Text(text = "Game Over")
    }

}