package com.ananth.composebasics.performance_best_practices

//import androidx.activity.compose.ReportDrawnAfter
//import androidx.activity.compose.ReportDrawnWhen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.ananth.composebasics.lazy_layouts.LazyColumn

@Composable
fun Parent(modifier: Modifier = Modifier) {
    val offset by animateFloatAsState(targetValue = 10f)

    Column {
        Child(offset = offset)
        Child1(offset = { offset })
    }
}

//without deferring read
@Composable
fun Child(offset: Float) {
    Box(modifier = Modifier.offset(y = offset.dp))
}

//Deferring read with lambda
/**
 * Prefer lambda modifier when using frequently changing state.
 * And you should not have to recompose just to relayout a screen.
 * */
@Composable
fun Child1(offset: () -> Float) {
    Box(modifier = Modifier.offset(y = offset().dp))

    //more better way !!!
    //If we can read this lambda inside a modifier that is not run during composition we can skip composition altogether.
    //This offset modifier is run during the layout phase,so composition skipped altogether
    //Standard modifiers are always run during composition, mean if it is not a lambda modifier then it will always be run in composition.
    Box(modifier = Modifier.offset {
        IntOffset(x = 0, y = offset().toInt())
    })

}

//Recomposition
/**
 * ->Recomposition is the process of calling composable function again when inputs change.
 * ->When Compose recomposes based on new inputs, it only calls the functions or lambdas that might have changes, and skip the rest.
 * */

//Always try to use val keyword in data class to avoid recomposition

//derivedStateOf
/**
 * ->derivedStateOf{} is used when your state or key is changing more than you want to update your ui.
 * ->another words derivedStateOf{} = distinctUntilChanged from kotlin flow
 * ->remember that composables recompose when the state they read changes
 * ->derivedStateOF allows you to create a new state that only changes as mush as you need
 * */

@Composable
fun DerivedStateOf() {
    var userName by remember { mutableStateOf("") }
    val submitEnabled = isUsernameValid(userName)
}


@Composable
fun TestDerivedStateOf() {
    var userName by remember { mutableStateOf("") }
    val submitEnabled by remember { derivedStateOf { isUsernameValid(userName) } }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = userName, onValueChange = { newValue -> userName = newValue })
        Button(modifier = Modifier.padding(top = 20.dp), onClick = { }, enabled = submitEnabled) {
            Text(text = "Submit")
        }

    }
}

@Composable
fun NoNeedDerivedStateInThisCase() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    //remember(key), as much as input changing, we need to remember
    val fullName = remember(firstName, lastName) {
        firstName + lastName
    }

    Column(modifier = Modifier.padding(top = 100.dp, start = 16.dp, end = 16.dp)) {
        TextField(
            value = firstName,
            onValueChange = { newValue -> firstName = newValue },
            placeholder = {
                Text(
                    text = "first name"
                )
            })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = lastName,
            onValueChange = { newValue -> lastName = newValue },
            placeholder = {
                Text(
                    text = "last name"
                )
            })

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = fullName)
    }
}

fun isUsernameValid(userName: String) = userName == "ananth"

//derivedStateOf  vs remember(key)

/**
 * ->derivedStateOf{} State is changing more than you want to update your ui
 * ->remember(key){} state needs to change as much as key changes.
 * */


//reportFullyDrawn()
/**
 * Report to the system that your app is now fully drawn, for diagnostic and optimization purposes
 * */

@Composable
fun ReportDrawnWhenSample() {
    var contentComposed by remember { mutableStateOf(false) }
    val lazyListState = rememberLazyListState()

    androidx.compose.foundation.lazy.LazyColumn {
        item {
            contentComposed = true
            Text(text = "Hello world")
        }
    }
    //this will call reportFullyDrawn when suspend function completes, this allows you to easily wait for an animation to finish or for data to load
//    ReportDrawnAfter{
//        lazyListState.animateScrollToItem(10)
//    }
//    ReportDrawnWhen {
//        contentComposed
//    }
}