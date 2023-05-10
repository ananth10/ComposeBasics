package com.ananth.composebasics.basic_layouts

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ananth.composebasics.ui.theme.MyBasicLayoutTheme

@Composable
fun MyApp(modifier: Modifier=Modifier) {
  Scaffold(modifier=modifier, bottomBar = {MyBottomNavigation()}
  ){ padding ->
      HomeScreen()
  }
}

@Preview
@Composable
fun PreviewMyApp() {
    MyBasicLayoutTheme {
        MyApp()
    }
}