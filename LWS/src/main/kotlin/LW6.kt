import kotlin.math.pow

class LW6 {
    companion object {
        fun arithmetic(n: Int, a: Int = 0, d: Int = 1): Int {
            return a + (n - 1) * d
        }

        fun task1() {
            val result = arithmetic(10)
            println("10-й член арифметической прогрессии: $result")
        }

        fun area(a: Int): Int {
            return a * a
        }

        fun area(a: Int, b: Int): Int {
            return a * b
        }

        fun task2() {
            val square = area(5)
            val rectangle = area(5, 3)

            println("Площадь квадрата со стороной 5: $square")
            println("Площадь прямоугольника 5x3: $rectangle")
        }

        fun average(vararg numbers: Int): Double {
            var sum = 0
            for (n in numbers) {
                sum += n
            }
            return sum.toDouble() / numbers.size
        }

        fun task3() {
            val result = average(1, 2, 3, 4, 5)
            println("Среднее арифметическое чисел (1, 2, 3, 4, 5): $result")
        }

        fun deposit(type: String): (Double, Double, Int) -> Double {
            return when (type) {
                "simple" -> { s0, r, n ->
                    s0 * (1 + (r / 100) * n)
                }

                "compound" -> { s0, r, n ->
                    s0 * (1 + (r / 100)).pow(n.toDouble())
                }

                else -> {
                    { _, _, _ -> 0.0 }
                }
            }
        }

        fun task4() {
            val simple = deposit("simple")
            val compound = deposit("compound")

            val s1 = simple(1000.0, 10.0, 2)
            val s2 = compound(1000.0, 10.0, 2)

            println("Сумма по простым процентам: $s1")
            println("Сумма по сложным процентам: $s2")
        }

        fun createProduct(name: String, price: Double): (Int) -> Unit {
            return { quantity ->
                val total = price * quantity
                println("В корзину добавлен $name в количестве $quantity на сумму $total")
            }
        }

        fun task5() {
            val addApple = createProduct("Яблоки", 50.0)
            val addMilk = createProduct("Молоко", 80.0)

            addApple(3)
            addMilk(2)
        }
    }
}