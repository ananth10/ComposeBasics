package com.ananth.composebasics.lazy_layouts

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.R
import com.ananth.composebasics.data.AppData
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumn(modifier: Modifier = Modifier, list: List<AppData.DrawableStringPair>) {
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    println("firstVisibleItemIndex: ${remember { derivedStateOf { state.firstVisibleItemIndex } }}")
    println("firstVisibleItemScrollOffset: ${remember { derivedStateOf { state.firstVisibleItemScrollOffset } }}")
    remember { derivedStateOf { state.layoutInfo.visibleItemsInfo.map { println(it.index) } } }
    val showScrollToTopButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        androidx.compose.foundation.lazy.LazyColumn(
            state = state,
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item() {
                Text(text = "List Header", style = MaterialTheme.typography.h6)
                Divider(modifier = modifier.height(2.dp), thickness = 1.dp)
            }
            items(list, key = { it.text }) { item ->
                //            AlignYourBody(drawable = item.drawable, text = item.text)
                Column(modifier = modifier.animateItemPlacement(tween(100))) {
                    ListItem(drawable = item.drawable, title = item.text)
                }
            }
        }

        if (showScrollToTopButton) {
            OutlinedButton(modifier = modifier.align(Alignment.BottomCenter), onClick = {
                coroutineScope.launch {
                    state.animateScrollToItem(0)
                }
            }) {
                Text(text = "Scroll to Top")
            }
        }
    }
}

@Composable
fun ListItem(modifier: Modifier = Modifier, @DrawableRes drawable: Int, @StringRes title: Int) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.size(100.dp)
        )
        Text(text = stringResource(id = title))
    }
}

//custom arrangement
object TopWithFooter : Arrangement.Vertical {
    override fun Density.arrange(totalSize: Int, sizes: IntArray, outPositions: IntArray) {
        var y = 0
        //arranging item one after another
        sizes.forEachIndexed { index, size ->
            outPositions[index] = y
            y += size
        }
        //if total height is lower than viewport height
        if (y < totalSize) {
            val lastIndex = outPositions.lastIndex
            outPositions[lastIndex] = totalSize - sizes.last()
        }
    }

}

@Composable
fun DrawBehind() {
    val color by animateColorAsState(targetValue = Color.Cyan)
//drawBehind will only trigger Draw phase and skip composition and layout phases.
    Box(modifier = Modifier
        .fillMaxSize()
        .drawBehind {
            drawRect(color)
        })
}

@Preview
@Composable
fun PreviewListItem() {
    ListItem(drawable = R.drawable.ab1_inversions, title = R.string.ab1_inversions)
}