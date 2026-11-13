package com.example.labwork23.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class ColorStyle { Purple, Green }

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6750A4),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF625B71),
    onSecondary = Color(0xFFFFFFFF),
    background = Color(0xFFFFFBFE),
    onBackground = Color(0xFF1D1B20),
    surface = Color(0xFFFFFBFE),
    onSurface = Color(0xFF1D1B20),
    primaryContainer = Color(0xFFEADDFF),
    onPrimaryContainer = Color(0xFF21005D)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD0BCFF),
    onPrimary = Color(0xFF381E72),
    secondary = Color(0xFFCCC2DC),
    onSecondary = Color(0xFF332D41),
    background = Color(0xFF141218),
    onBackground = Color(0xFFE6E0E9),
    surface = Color(0xFF141218),
    onSurface = Color(0xFFE6E0E9),
    primaryContainer = Color(0xFF4F378B),
    onPrimaryContainer = Color(0xFFEADDFF)
)

private val GreenLightColorScheme = lightColorScheme(
    primary = Color(0xFF386A20),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF55624C),
    onSecondary = Color(0xFFFFFFFF),
    background = Color(0xFFF9FAEF),
    onBackground = Color(0xFF1A1C18),
    surface = Color(0xFFF9FAEF),
    onSurface = Color(0xFF1A1C18),
    primaryContainer = Color(0xFFB8F397),
    onPrimaryContainer = Color(0xFF082100)
)

private val GreenDarkColorScheme = darkColorScheme(
    primary = Color(0xFF9CD67D),
    onPrimary = Color(0xFF103800),
    secondary = Color(0xFFBDCBB0),
    onSecondary = Color(0xFF283420),
    background = Color(0xFF11140F),
    onBackground = Color(0xFFE2E3D8),
    surface = Color(0xFF11140F),
    onSurface = Color(0xFFE2E3D8),
    primaryContainer = Color(0xFF205107),
    onPrimaryContainer = Color(0xFFB8F397)
)

@Composable
fun TrackerTheme(dark: Boolean, colorStyle: ColorStyle, content: @Composable () -> Unit) {
    val scheme = when (colorStyle) {
        ColorStyle.Purple -> if (dark) DarkColorScheme else LightColorScheme
        ColorStyle.Green -> if (dark) GreenDarkColorScheme else GreenLightColorScheme
    }
    MaterialTheme(colorScheme = scheme, typography = TrackerTypography, content = content)
}
