package com.ananth.composebasics.basic_layouts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.R
import com.ananth.composebasics.data.AppData
import com.ananth.composebasics.ui.theme.MyBasicLayoutTheme

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        placeholder = { Text(text = stringResource(id = R.string.placeholder_search)) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )
}

@Composable
fun AlignYourBody(@DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.subtitle1,
            modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(AppData.favoriteCollectionsData) { item ->
            FavoriteCollectionCard(drawable = item.drawable, item.text)
        }
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            modifier = modifier.width(192.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                modifier = modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                stringResource(id = text),
                style = MaterialTheme.typography.subtitle1,
                modifier = modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(AppData.alignYourBodyData) { item ->
            AlignYourBody(drawable = item.drawable, text = item.text)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewSearchBar() {
    MyBasicLayoutTheme() {
        SearchBar()
    }
}

@Preview
@Composable
fun PreviewAlignYourBody() {
    MyBasicLayoutTheme() {
        AlignYourBody(R.drawable.ab1_inversions, R.string.ab1_inversions)
    }
}

@Preview
@Composable
fun PreviewFavoriteCollectionCard() {
    MyBasicLayoutTheme() {
        FavoriteCollectionCard(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations)
    }
}

@Preview
@Composable
fun PreviewAlignYourBodyRow() {
    AlignYourBodyRow()
}

@Preview
@Composable
fun PreviewFavoriteCollectionsGrid() {
    FavoriteCollectionsGrid()
}