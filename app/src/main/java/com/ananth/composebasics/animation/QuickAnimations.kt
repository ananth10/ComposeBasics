package com.ananth.composebasics.animation

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

//1. Showing/Hiding content with AnimatedVisibility

@Composable
fun ClickableMessage(modifier: Modifier = Modifier, message: String) {

    var showDetails by remember { mutableStateOf(false) }
    var questionIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDetails = !showDetails }) {
            Text(text = if (!showDetails) "Show details" else "Hide details")
        }

        AnimatedVisibility(showDetails, enter = fadeIn(), exit = fadeOut()) {
            Text(text = message)
        }

        ExpandingText(modifier, R.string.dummy_txt)
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { questionIndex++ }, enabled = questionIndex < 5) {
            Text(text = "Increase Progress")
        }
        Spacer(modifier = Modifier.height(30.dp))
        SurveyTopAppProgress(questionIndex = questionIndex, totalQuestionsCount = 6)
        Spacer(modifier = Modifier.height(30.dp))
        ImageBorderAnimation(modifier)
    }
}

@Composable
fun ExpandingText(modifier: Modifier = Modifier, @StringRes description: Int) {
    var expanded by remember { mutableStateOf(false) }

    //add animateContentSize modifier to get an instantly smooth change
    Text(
        text = stringResource(id = description),
        modifier = modifier
            .padding(top = 30.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .clickable {
                expanded = !expanded
            },
        maxLines = if (!expanded) 2 else 10
    )
}

//Tip 3: animatedContent with animation spec, pls check crane sample app and doc.

//Tip 4: Jet survey app - animateFloatAsState

@Composable
fun SurveyTopAppProgress(
    questionIndex: Int,
    totalQuestionsCount: Int
) {
    val progress by animateFloatAsState((questionIndex + 1) / totalQuestionsCount.toFloat())

    LinearProgressIndicator(progress = progress)
}

//tip 5: border animation

@Composable
fun ImageBorderAnimation(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
    )
    Image(
        painter = painterResource(id = R.drawable.ab1_inversions),
        modifier = modifier
            .drawBehind {
                rotate(rotationAnimation.value) {
                    drawCircle(
                        brush = Brush.horizontalGradient(colors = listOf(Color.Cyan, Color.Red)),
                        style = Stroke(10f)
                    )
                }

            }
            .padding(10.dp)
            .size(100.dp)
            .clip(CircleShape),
        contentDescription = null
    )
}