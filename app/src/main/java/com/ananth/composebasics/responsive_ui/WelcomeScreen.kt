package com.ananth.composebasics.responsive_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.R

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, widthSizeClass: WindowWidthSizeClass) {
    if (widthSizeClass == WindowWidthSizeClass.Expanded) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ab1_inversions),
                modifier = modifier.weight(1f),
                contentDescription = null
            )
            Column {
                Text(text = "")
                Button(onClick = { }) {
                    Text(text = "Continue")
                }
            }
        }
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(64.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ab1_inversions),
                modifier = modifier.weight(1f),
                contentDescription = null
            )
            Text(text = "")
            Button(onClick = { }) {
                Text(text = "Continue")
            }
        }
    }
}

