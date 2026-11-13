package com.example.labwork23.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment


@Composable
fun SettingsScreen() {
    val colors = MaterialTheme.colorScheme
    var reminders by rememberSaveable { mutableStateOf(false) }

    Text("Уведомления", color = colors.primary, style = MaterialTheme.typography.headlineMedium)
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Напоминания", Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
        Switch(
            reminders,
            onCheckedChange = { reminders = it },
            colors = SwitchDefaults.colors(checkedTrackColor = colors.secondary, checkedThumbColor = colors.onSecondary)
        )
    }
    Text("Настройка напоминаний о задачах", style = MaterialTheme.typography.bodySmall)
}
