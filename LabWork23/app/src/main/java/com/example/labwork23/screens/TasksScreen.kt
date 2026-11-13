package com.example.labwork23.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment


@Composable
fun TasksScreen(onNewTask: () -> Unit) {
    val colors = MaterialTheme.colorScheme
    Text("На сегодня", color = colors.primary, style = MaterialTheme.typography.headlineMedium)
    for (task in listOf("Проверить расписание", "Подготовить материалы", "Сдать отчёт")) {
        key(task) {
            var done by rememberSaveable { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(done, { done = it }, colors = CheckboxDefaults.colors(checkedColor = colors.secondary, checkmarkColor = colors.onSecondary))
                Text(task, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
    Button(
        onClick = onNewTask,
        colors = ButtonDefaults.buttonColors(containerColor = colors.primary, contentColor = colors.onPrimary)
    ) { Text("Новая задача") }
}
