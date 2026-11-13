package com.example.labwork17

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.labwork17.screens.*

private enum class Page(val label: String) {
    Registration("Регистрация"), Pin("ПИН-код"), About("О себе"), Font("Шрифт")
}

@Composable
fun InputLab() {
    var page by rememberSaveable { mutableStateOf(Page.Registration) }
    val stateHolder = rememberSaveableStateHolder()
    Surface(Modifier.fillMaxSize()) {
        Column(Modifier.safeDrawingPadding().imePadding()) {
            PrimaryScrollableTabRow(selectedTabIndex = page.ordinal, edgePadding = 0.dp) {
                Page.entries.forEach { item ->
                    Tab(selected = item == page, onClick = { page = item }, text = { Text(item.label) })
                }
            }
            stateHolder.SaveableStateProvider(page.name) {
                Column(
                    Modifier.weight(1f).fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    when (page) {
                        Page.Registration -> RegistrationScreen()
                        Page.Pin -> PinScreen()
                        Page.About -> AboutScreen()
                        Page.Font -> FontScreen()
                    }
                }
            }
        }
    }
}
