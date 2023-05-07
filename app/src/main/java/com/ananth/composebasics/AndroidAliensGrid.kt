package com.ananth.composebasics

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.components.AndroidAlien

@Composable
fun AndroidAliensGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(5)) {
        items(50) {
            AndroidAlien(color = Color.Red, modifier)
        }
    }
}