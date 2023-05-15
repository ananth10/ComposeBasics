package com.ananth.composebasics.drawing

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyDrawing(modifier: Modifier = Modifier) {
    Column {
        Canvas(modifier = modifier.fillMaxSize(), onDraw = {
            drawCircle(
                Color.Magenta,
                center = Offset(
                    20.dp.toPx(),
                    100.dp.toPx()
                )
            )
        })
        //using scale
        Canvas(modifier = modifier.fillMaxSize(), onDraw = {
            scale(scaleX = 10f, scaleY = 15f) {
                drawCircle(
                    Color.Magenta,
                    center = Offset(
                        20.dp.toPx(),
                        100.dp.toPx()
                    )
                )
            }
        })

        //using translate
        Canvas(modifier = modifier.fillMaxSize(), onDraw = {
            translate(left = 100f, top = -300f) {
                drawCircle(
                    Color.Magenta,
                    center = Offset(
                        20.dp.toPx(),
                        100.dp.toPx()
                    )
                )
            }
        })

        //using rotate

        Canvas(modifier = modifier.fillMaxSize(), onDraw = {
            rotate(degrees = 45f) {
                drawRect(
                    color = Color.Cyan,
                    topLeft = Offset(x = size.width / 3f, y = size.height / 3F),
                    size = size / 3F
                )
            }
        })

        //using inset
        Canvas(modifier = modifier.fillMaxSize(), onDraw = {
            val quadranSize = size / 2F
            inset(horizontal = 50f, vertical = 30f) {
                drawRect(color = Color.Blue, size = quadranSize)
            }
        })

        //using Multiple transformations
        Canvas(modifier = modifier.fillMaxSize(), onDraw = {
            withTransform({
                translate(left = size.width / 5F)
                rotate(degrees = 45F)
            }) {
                drawRect(color = Color.Blue, size = Size(50F, 100F))
            }
        })
    }
}

@Preview
@Composable
fun PreviewMyDrawing() {
    MyDrawing()
}