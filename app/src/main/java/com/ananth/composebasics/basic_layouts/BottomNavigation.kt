package com.ananth.composebasics.basic_layouts

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ananth.composebasics.R
import com.ananth.composebasics.ui.theme.MyBasicLayoutTheme

@Composable
fun MyBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(backgroundColor = MaterialTheme.colors.background, modifier = modifier) {
        BottomNavigationItem(selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.Send, contentDescription = null) },
            label = { Text(stringResource(id = R.string.bottom_navigation_home)) })
        BottomNavigationItem(selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(stringResource(id = R.string.bottom_navigation_profile)) })
    }
}

@Preview
@Composable
fun PreviewMyBottomNavigation() {
    MyBasicLayoutTheme() {
        MyBottomNavigation()
    }
}