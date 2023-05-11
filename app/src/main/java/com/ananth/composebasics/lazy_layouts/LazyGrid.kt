package com.ananth.composebasics.lazy_layouts

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.data.AppData

@Composable
fun LazyVertGrid(modifier: Modifier = Modifier, list: List<AppData.DrawableStringPair>) {
    val state = rememberLazyGridState()
    println("firstVisibleItemIndex: ${remember { derivedStateOf { state.firstVisibleItemIndex } }}")
    println("firstVisibleItemScrollOffset: ${remember { derivedStateOf { state.firstVisibleItemScrollOffset } }}")
    remember { derivedStateOf { state.layoutInfo.visibleItemsInfo.map { println(it.index) } } }
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
//        columns = object : GridCells {
//            override fun Density.calculateCrossAxisCellSizes(
//                availableSize: Int,
//                spacing: Int
//            ): List<Int> {
//                val firstColumn = (availableSize - spacing) * 2 / 3
//                val secondColumn = availableSize - spacing - firstColumn
//                return listOf(firstColumn, secondColumn)
//            }
//
//        },
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        item(span = {
            GridItemSpan(maxLineSpan)
        }) {
            Text(text = "Section Header")
        }
        items(list) { item ->
            ListGridItem(drawable = item.drawable, title = item.text)
        }
    }
}

@Composable
fun ListGridItem(modifier: Modifier = Modifier, @DrawableRes drawable: Int, @StringRes title: Int) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.size(200.dp)
        )
        Text(text = stringResource(id = title))
    }
}