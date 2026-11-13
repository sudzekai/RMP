package com.example.labwork17.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation


private const val PIN_LENGTH = 4
private const val CORRECT_PIN = "2486"
private const val MAX_ATTEMPTS = 3

@Composable
fun PinScreen() {
    var code by rememberSaveable { mutableStateOf("") }
    var attempts by rememberSaveable { mutableIntStateOf(MAX_ATTEMPTS) }
    var verified by rememberSaveable { mutableStateOf(false) }
    var message by rememberSaveable { mutableStateOf("") }
    val enabled = attempts > 0 && !verified

    OutlinedTextField(
        value = code,
        onValueChange = { value ->
            if (value.length <= PIN_LENGTH && value.all { it in '0'..'9' }) code = value
        },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("ПИН-код") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = PasswordVisualTransformation(),
        enabled = enabled,
        singleLine = true
    )
    Button(
        enabled = enabled && code.length == PIN_LENGTH,
        onClick = {
            verified = code == CORRECT_PIN
            if (verified) {
                message = "Код верный"
            } else {
                attempts--
                message = if (attempts == 0) "Неверный код. Ввод заблокирован"
                else "Неверный код. Осталось попыток: $attempts"
                code = ""
            }
        }
    ) { Text("Отправить") }
    if (message.isNotEmpty()) Text(message)
}
