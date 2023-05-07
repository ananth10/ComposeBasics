package com.ananth.composebasics.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.ananth.composebasics.R

@Composable
fun AndroidAlien(
    color: Color,
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color = color)
    )
}