package com.example.labwork20

data class Product(val id: Int, val name: String, val price: Int)

val products = listOf(
    Product(1, "Блокнот", 260),
    Product(2, "Ручка", 70),
    Product(3, "Линейка", 90),
    Product(4, "Карандаш", 55),
    Product(5, "Маркер", 140),
    Product(6, "Пенал", 490),
    Product(7, "Тетрадь", 105),
    Product(8, "Альбом", 220),
    Product(9, "Ластик", 60),
    Product(10, "Точилка", 120)
)
