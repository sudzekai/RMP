package com.example.labwork23

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.labwork23.screens.*
import com.example.labwork23.ui.theme.ColorStyle
import com.example.labwork23.ui.theme.TrackerTheme

private enum class Page(val title: String) {
    Tasks("Задачи"), NewTask("Новая задача"), Settings("Настройки")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskTracker() {
    val systemDark = isSystemInDarkTheme()
    var dark by rememberSaveable { mutableStateOf(systemDark) }
    var colorStyle by rememberSaveable { mutableStateOf(ColorStyle.Purple) }
    var page by rememberSaveable { mutableStateOf(Page.Tasks) }
    var menuOpen by remember { mutableStateOf(false) }
    val stateHolder = rememberSaveableStateHolder()

    TrackerTheme(dark, colorStyle) {
        val colors = MaterialTheme.colorScheme
        Scaffold(
            containerColor = colors.background,
            contentColor = colors.onBackground,
            topBar = {
                TopAppBar(
                    title = { Text(page.title) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colors.primaryContainer,
                        titleContentColor = colors.onPrimaryContainer,
                        navigationIconContentColor = colors.onPrimaryContainer,
                        actionIconContentColor = colors.onPrimaryContainer
                    ),
                    navigationIcon = {
                        Box {
                            IconButton(onClick = { menuOpen = true }) {
                                Icon(painterResource(R.drawable.menu), "Меню")
                            }
                            DropdownMenu(expanded = menuOpen, onDismissRequest = { menuOpen = false }) {
                                Page.entries.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(item.title) },
                                        onClick = { page = item; menuOpen = false }
                                    )
                                }
                            }
                        }
                    },
                    actions = {
                        IconButton(onClick = { dark = !dark }) {
                            Icon(
                                painterResource(if (dark) R.drawable.sun else R.drawable.moon),
                                if (dark) "Включить светлую тему" else "Включить тёмную тему"
                            )
                        }
                        IconButton(onClick = {
                            colorStyle = if (colorStyle == ColorStyle.Purple) ColorStyle.Green else ColorStyle.Purple
                        }) {
                            Icon(
                                painterResource(R.drawable.palette),
                                if (colorStyle == ColorStyle.Purple) "Выбрать зелёную палитру" else "Выбрать фиолетовую палитру"
                            )
                        }
                    }
                )
            }
        ) { padding ->
            stateHolder.SaveableStateProvider(page.name) {
                Column(
                    Modifier.fillMaxSize().padding(padding).imePadding()
                        .verticalScroll(rememberScrollState()).padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    when (page) {
                        Page.Tasks -> TasksScreen(onNewTask = { page = Page.NewTask })
                        Page.NewTask -> NewTaskScreen(onBack = { page = Page.Tasks })
                        Page.Settings -> SettingsScreen()
                    }
                }
            }
        }
    }
}
