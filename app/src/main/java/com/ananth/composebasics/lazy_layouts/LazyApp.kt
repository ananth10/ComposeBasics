package com.ananth.composebasics.lazy_layouts

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ananth.composebasics.data.AppData

@Composable
fun LazyApp(modifier: Modifier = Modifier) {
    val list = AppData.alignYourBodyData
    MaterialTheme {
        LazyColumn(modifier,list)
//          LazyVertGrid(modifier,list)
    }
}



