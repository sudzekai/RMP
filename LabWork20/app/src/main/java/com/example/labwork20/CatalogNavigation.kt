package com.example.labwork20

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork20.screens.*

private enum class Route(val title: String) {
    Login("Авторизация"), Register("Регистрация"), Catalog("Список товаров"), Product("Товар")
}

private const val PRODUCT_ID = "productId"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogNavigation(onExit: () -> Unit) {
    val navController = rememberNavController()
    val goBack: () -> Unit = { if (!navController.popBackStack()) onExit() }

    NavHost(navController, startDestination = Route.Login.name) {
        composable(Route.Login.name) {
            Page(Route.Login.title, goBack) {
                LoginScreen(
                    onLogin = { navController.navigate(Route.Catalog.name) },
                    onRegister = { navController.navigate(Route.Register.name) }
                )
            }
        }
        composable(Route.Register.name) {
            Page(Route.Register.title, goBack) {
                RegistrationScreen(onConfirm = goBack)
            }
        }
        composable(Route.Catalog.name) {
            Page(Route.Catalog.title, goBack) {
                CatalogScreen(onProductClick = { id -> navController.navigate("${Route.Product.name}/$id") })
            }
        }
        composable(
            "${Route.Product.name}/{$PRODUCT_ID}",
            arguments = listOf(navArgument(PRODUCT_ID) { type = NavType.IntType })
        ) { entry ->
            val id = entry.arguments?.getInt(PRODUCT_ID)
            Page(Route.Product.title, goBack) {
                ProductScreen(products.find { it.id == id })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Page(title: String, onBack: () -> Unit, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = { TextButton(onClick = onBack) { Text("Назад") } },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        Box(Modifier.fillMaxSize().padding(padding).imePadding().padding(horizontal = 16.dp, vertical = 12.dp)) {
            content()
        }
    }
}
