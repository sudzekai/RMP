package com.example.labwork20.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.labwork20.products


@Composable
fun CatalogScreen(onProductClick: (Int) -> Unit) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(products, key = { it.id }) { product ->
            ListItem(
                headlineContent = { Text(product.name) },
                modifier = Modifier.clickable { onProductClick(product.id) }
            )
            HorizontalDivider()
        }
    }
}
