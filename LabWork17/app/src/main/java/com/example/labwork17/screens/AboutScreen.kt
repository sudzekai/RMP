package com.example.labwork17.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



private const val MAX_LENGTH = 300

@Composable
fun AboutScreen() {
    var about by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = about,
        onValueChange = { value -> if (value.length <= MAX_LENGTH) about = value },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("О себе") },
        minLines = 8,
        maxLines = 8
    )
    Text("Осталось символов: ${MAX_LENGTH - about.length}")
}
