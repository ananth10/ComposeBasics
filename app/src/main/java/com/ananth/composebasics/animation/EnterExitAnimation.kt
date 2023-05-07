package com.ananth.composebasics.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ToggleVisibility() {
    var visible by remember { mutableStateOf(true) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { visible = !visible }, modifier = Modifier.size(100.dp)) {
            Text(text = "Click")
        }
        AnimatedVisibility(visible, enter = fadeIn() + scaleIn(), exit = fadeOut() + scaleOut()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .padding(top = 20.dp)
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ContentAnimation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember { mutableStateOf(0) }

        Button(onClick = { count += 1 }) {
            Text(text = "Add")
        }
        AnimatedContent(targetState = count, transitionSpec = {
            fadeIn() + scaleIn() with fadeOut() + scaleOut()
        }) { targetCount ->
            Text(text = "Count: $targetCount")
        }
    }
}

@Composable
fun AnimationSpec() {
    var isOn by remember{ mutableStateOf(true) }
    val offsetX by animateDpAsState(targetValue = if(isOn)512.dp else 0.dp, animationSpec = tween(3000))
}

@Preview
@Composable
fun previewToggleVisibility() {
    ToggleVisibility()
}

@Preview
@Composable
fun previewContentAnimation() {
    ContentAnimation()
}