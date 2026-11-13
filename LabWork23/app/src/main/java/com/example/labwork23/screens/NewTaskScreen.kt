package com.example.labwork23.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment


@Composable
fun NewTaskScreen(onBack: () -> Unit) {
    val colors = MaterialTheme.colorScheme
    var title by rememberSaveable { mutableStateOf("") }
    var note by rememberSaveable { mutableStateOf("") }
    var important by rememberSaveable { mutableStateOf(false) }
    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = colors.primary,
        focusedLabelColor = colors.primary,
        unfocusedBorderColor = colors.secondary
    )

    OutlinedTextField(title, { title = it }, Modifier.fillMaxWidth(), label = { Text("Название") }, singleLine = true, colors = fieldColors)
    OutlinedTextField(note, { note = it }, Modifier.fillMaxWidth(), label = { Text("Описание") }, minLines = 3, colors = fieldColors)
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(important, { important = it }, colors = CheckboxDefaults.colors(checkedColor = colors.secondary, checkmarkColor = colors.onSecondary))
        Text("Важная задача")
    }
    TextButton(onClick = onBack, colors = ButtonDefaults.textButtonColors(contentColor = colors.secondary)) {
        Text("К списку задач")
    }
}
