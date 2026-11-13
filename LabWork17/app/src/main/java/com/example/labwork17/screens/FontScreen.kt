package com.example.labwork17.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt


private enum class TextColor(val label: String, val color: Color) {
    Black("Чёрный", Color.Black),
    Red("Красный", Color(0xFFB02424)),
    Green("Зелёный", Color(0xFF26642D)),
    Blue("Синий", Color(0xFF234EAE)),
    Violet("Фиолетовый", Color(0xFF672589))
}

@Composable
fun FontScreen() {
    var selectedColor by rememberSaveable { mutableStateOf(TextColor.Black) }
    var size by rememberSaveable { mutableIntStateOf(16) }
    var bold by rememberSaveable { mutableStateOf(false) }
    var italic by rememberSaveable { mutableStateOf(false) }

    Text(
        "Пример текста",
        color = selectedColor.color,
        fontSize = size.sp,
        fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
        fontStyle = if (italic) FontStyle.Italic else FontStyle.Normal
    )
    Column(Modifier.selectableGroup()) {
        TextColor.entries.forEach { option ->
            val selected = option == selectedColor
            Row(
                Modifier.fillMaxWidth().heightIn(min = 48.dp)
                    .selectable(selected, role = Role.RadioButton, onClick = { selectedColor = option }),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected, onClick = null)
                Box(Modifier.size(16.dp).background(option.color))
                Text(option.label)
            }
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
        Slider(
            value = size.toFloat(),
            onValueChange = { size = it.roundToInt() },
            modifier = Modifier.weight(1f),
            valueRange = 10f..30f,
            steps = 19
        )
        Text("$size sp")
    }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Switch(bold, onCheckedChange = { bold = it })
        Text("Полужирный")
    }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Switch(italic, onCheckedChange = { italic = it })
        Text("Курсив")
    }
}
