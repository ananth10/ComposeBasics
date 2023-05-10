package com.ananth.composebasics.basic_state

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    WellnessTaskItemStateLess(
        taskName = taskName,
        checked = checked,
        onCheckedChange = { newValue -> onCheckedChange(newValue) },
        onClose = onClose,
        modifier = modifier
    )
}

@Composable
fun WellnessTaskItemStateLess(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = modifier
                .weight(1f)
                .padding(start = 16.dp), text = taskName
        )

        Checkbox(checked = checked, onCheckedChange = onCheckedChange)

        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = null)
        }
    }
}

@Preview(backgroundColor = 0xFFF0EAE2)
@Composable
fun PreviewWellnessTaskItem() {
    WellnessTaskItem("My Task", true, {}, {})
}