package com.example.labwork16

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun ResourcesScreen() {
    var query by rememberSaveable { mutableStateOf("") }
    var menuOpen by rememberSaveable { mutableStateOf(false) }
    var clock by remember { mutableStateOf(Calendar.getInstance()) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(60_000L - System.currentTimeMillis() % 60_000L)
            clock = Calendar.getInstance()
        }
    }

    val hour = clock.get(Calendar.HOUR_OF_DAY)
    val minute = clock.get(Calendar.MINUTE)
    val year = clock.get(Calendar.YEAR)
    val ink = colorResource(R.color.resource_ink)
    val accent = colorResource(R.color.resource_accent)
    val imageSize = Modifier.size(
        dimensionResource(R.dimen.image_width),
        dimensionResource(R.dimen.image_height)
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(R.color.resource_background),
        contentColor = ink
    ) {
        Column(
            Modifier.safeDrawingPadding().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                stringResource(R.string.app_name),
                fontFamily = LabFont,
                style = MaterialTheme.typography.headlineMedium
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier.weight(1f).height(dimensionResource(R.dimen.search_height)),
                    placeholder = { Text(stringResource(R.string.search), fontFamily = LabFont) },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = accent,
                        unfocusedBorderColor = colorResource(R.color.resource_outline)
                    )
                )
                Box {
                    Button(
                        onClick = { menuOpen = true },
                        modifier = Modifier.size(
                            dimensionResource(R.dimen.menu_width),
                            dimensionResource(R.dimen.menu_height)
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = accent,
                            contentColor = colorResource(R.color.resource_on_accent)
                        )
                    ) { Text(stringResource(R.string.menu), fontFamily = LabFont) }
                    DropdownMenu(expanded = menuOpen, onDismissRequest = { menuOpen = false }) {
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.app_name), fontFamily = LabFont) },
                            onClick = { menuOpen = false }
                        )
                    }
                }
            }
            Column(
                Modifier.weight(1f).fillMaxWidth().verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val hours = pluralStringResource(R.plurals.hours, hour, hour)
                val minutes = pluralStringResource(R.plurals.minutes, minute, minute)
                Text("$hours $minutes", fontFamily = LabFont)
                stringArrayResource(R.array.developers).forEach { developer ->
                    Text(stringResource(R.string.copyright, developer, year), fontFamily = LabFont)
                }
                Icon(painterResource(R.drawable.ic_search), stringResource(R.string.search), imageSize, tint = accent)
                Image(
                    painterResource(R.drawable.android_image),
                    stringResource(R.string.image_description),
                    imageSize.clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
