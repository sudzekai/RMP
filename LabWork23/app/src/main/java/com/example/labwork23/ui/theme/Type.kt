package com.example.labwork23.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.labwork23.R

private val TrackerFont = FontFamily(Font(R.font.lab_serif))

val TrackerTypography = Typography(
    headlineMedium = TextStyle(fontFamily = TrackerFont, fontSize = 30.sp, lineHeight = 36.sp, fontWeight = FontWeight.Bold),
    titleLarge = TextStyle(fontFamily = TrackerFont, fontSize = 24.sp, lineHeight = 30.sp, fontWeight = FontWeight.Bold),
    bodyLarge = TextStyle(fontFamily = TrackerFont, fontSize = 20.sp, lineHeight = 26.sp),
    bodyMedium = TextStyle(fontFamily = TrackerFont, fontSize = 18.sp, lineHeight = 23.sp),
    bodySmall = TextStyle(fontFamily = TrackerFont, fontSize = 15.sp, lineHeight = 20.sp),
    labelLarge = TextStyle(fontFamily = TrackerFont, fontSize = 17.sp, lineHeight = 22.sp, fontWeight = FontWeight.SemiBold)
)
