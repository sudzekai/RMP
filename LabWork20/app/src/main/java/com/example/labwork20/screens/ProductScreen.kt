package com.example.labwork20.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.labwork20.Product


@Composable
fun ProductScreen(product: Product?) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (product == null) {
            Text("Товар не найден")
        } else {
            Text(product.name, style = MaterialTheme.typography.headlineSmall)
            Text("${product.price} ₽", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
