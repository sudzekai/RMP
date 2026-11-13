package com.example.labwork20.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun LoginScreen(onLogin: () -> Unit, onRegister: () -> Unit) {
    CredentialsForm(onConfirm = onLogin, secondaryAction = onRegister)
}
