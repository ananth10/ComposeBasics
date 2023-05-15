package com.ananth.composebasics.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.R

@Composable
fun MyTextField(modifier: Modifier = Modifier) {
    var textFieldValue by remember { mutableStateOf("") }
    val GradientColors = listOf(Color.Cyan, Color.Red)
    Column {
        TextField(
            value = textFieldValue,
            onValueChange = { newValue -> textFieldValue = newValue },
            label = { Text("Message composers") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Cyan,
                unfocusedIndicatorColor = Color.Blue
            ),
            modifier = Modifier.border(
                border = BorderStroke(
                    brush = Brush.linearGradient(listOf(Color.Cyan, Color.Red)),
                    width = 2.dp
                ),
                shape = CutCornerShape(12.dp)
            )
        )

        Spacer(modifier = Modifier.height(30.dp))
        BasicTextField(
            value = textFieldValue,
            onValueChange = { value -> textFieldValue = value },
            cursorBrush = Brush.linearGradient(GradientColors),
            decorationBox = { innerTextField ->
                Row(modifier = modifier.background(Color.LightGray)) {Int
                    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
                    //textfield component
                }
            }
        )
    }
}