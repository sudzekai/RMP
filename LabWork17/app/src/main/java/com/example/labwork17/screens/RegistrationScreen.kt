package com.example.labwork17.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


private enum class Field(val label: String, val hint: String, val keyboard: KeyboardType) {
    Login("Логин", "Имя пользователя", KeyboardType.Text),
    Password("Пароль", "Введите пароль", KeyboardType.Password),
    Confirmation("Подтверждение пароля", "Повторите пароль", KeyboardType.Password),
    Phone("Номер телефона", "+7 900 000-00-00", KeyboardType.Phone),
    Email("Email", "name@example.com", KeyboardType.Email),
    Age("Возраст", "18", KeyboardType.Number),
    Website("Персональный сайт", "https://example.com", KeyboardType.Uri)
}

@Composable
fun RegistrationScreen() {
    var fields by rememberSaveable { mutableStateOf(Array(Field.entries.size) { "" }) }
    var accepted by rememberSaveable { mutableStateOf(false) }
    var message by rememberSaveable { mutableStateOf("") }

    Field.entries.forEach { field ->
        OutlinedTextField(
            value = fields[field.ordinal],
            onValueChange = { value -> fields = fields.copyOf().apply { this[field.ordinal] = value } },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(field.label) },
            placeholder = { Text(field.hint) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = field.keyboard),
            visualTransformation = if (field.keyboard == KeyboardType.Password) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        )
    }

    Row(
        Modifier.fillMaxWidth().toggleable(accepted, role = Role.Checkbox, onValueChange = { accepted = it })
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(accepted, onCheckedChange = null)
        Text("Я согласен на обработку своих персональных данных и принимаю условия Политики конфиденциальности и Пользовательского соглашения")
    }

    Button(
        enabled = accepted,
        onClick = {
            message = if (fields.all { it.isNotBlank() }) {
                "${fields[Field.Login.ordinal]}, вы зарегистрированы"
            } else {
                "Не все поля заполнены"
            }
        }
    ) { Text("Зарегистрироваться") }
    if (message.isNotEmpty()) Text(message)
}
