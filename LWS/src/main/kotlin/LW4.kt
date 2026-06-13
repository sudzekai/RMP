import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class LW4 {
    companion object {
        fun task1() {
            val daysArr = arrayOf(
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
            )
            var year: Int

            while (true) {
                print("Enter an year: ")
                try {
                    year = readln().toInt()
                    break
                } catch (e: Exception) {
                    println("year must be a int")
                }
            }

            var month: Int

            while (true) {
                print("Enter month number: ")
                try {
                    month = readln().toInt()

                    if (month !in 1..12) {
                        println("month must be less than 13 and greater than 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("month must be a int")
                }
            }

            val isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

            val days = if (month == 2 && isLeap) {
                daysArr[1] + 1
            } else {
                daysArr[month - 1]
            }

            val season = when (month) {
                in 3..5 -> "spring"
                in 6..8 -> "summer"
                in 9..11 -> "autumn"
                else -> "winter"
            }

            println("isLeap: $isLeap, days: $days, season: $season")
        }

        fun task2() {
            var a: Double
            while (true) {
                print("Enter first side: ")
                try {
                    a = readln().toDouble()
                    if (a < 1) {
                        println("Side must be > 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Side must be a number")
                }
            }

            var b: Double
            while (true) {
                print("Enter second side: ")
                try {
                    b = readln().toDouble()
                    if (b < 1) {
                        println("Side must be > 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Side must be a number")
                }
            }

            var c: Double
            while (true) {
                print("Enter third side: ")
                try {
                    c = readln().toDouble()
                    if (c < 1) {
                        println("Side must be > 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Side must be a number")
                }
            }

            val isTriangle = (a + b > c) && (a + c > b) && (b + c > a)

            if (!isTriangle) {
                println("Triangle does not exist")
                return
            }

            val isRavnosoronniy = (a == b) && (b == c)
            val isRavnobedrenniy = (a == b) || (a == c) || (b == c)

            when {
                isRavnosoronniy -> println("Triangle exists and is ravnosoronniy")
                isRavnobedrenniy -> println("Triangle exists and is ravnobedrenniy")
                else -> return
            }
        }

        fun task3() {
            val currencyArr = arrayOf("dollar", "euro")
            val dollarCost = 73.4
            val euroCost = 85.34

            var rubles: Float
            var chosenCurrency: String
            var result: String


            while (true) {
                print("Enter rubles: ")
                try {
                    rubles = readln().toFloat()

                    if (rubles < 0) {
                        println("rubles must be positive float")
                        continue
                    }

                    break
                } catch (e: Exception) {
                    println("Rubles must be a float")
                }
            }

            println("Available currencies: ${currencyArr.joinToString()}")
            print("Enter currency: ")
            chosenCurrency = readln()

            result = when (chosenCurrency) {
                "dollar" -> "$rubles rub = ${
                    String.format(
                        "%.2f",
                        rubles / dollarCost
                    )
                } dollars with cost $dollarCost rub per dollar"

                "euro" -> "$rubles rub = ${
                    String.format(
                        "%.2f",
                        rubles / euroCost
                    )
                } euros with cost $euroCost rub per euro"

                else -> "$rubles rub"
            }

            println(result)
        }

        fun task4() {
            var a: Double
            var x: Double
            var y: (Double, Double) -> Double
            var result: String

            while (true) {
                print("Enter num a: ")
                try {
                    a = readln().toDouble()
                    break
                } catch (e: Exception) {
                    println("a must be a number")
                }
            }

            while (true) {
                print("Enter num x: ")
                try {
                    x = readln().toDouble()
                    break
                } catch (e: Exception) {
                    println("x must be a number")
                }
            }

            y = when {
                x < 0 -> { a: Double, x: Double -> a + x * x * x }
                x in 0.0..<3.0 -> { a: Double, x: Double -> sin(x) + cos(x) }
                x in 3.0..<5.0 -> { a: Double, x: Double -> 1 / (a - x) }
                x >= 5 -> { a: Double, x: Double -> sqrt(x - a) }
                else -> return
            }

            result = try {
                String.format(
                    "%.3f", y(a, x)
                )
            } catch (e: Exception) {
                "Unable to get y"
            }

            println(
                result
            )
        }

        fun task5() {
            var purchaseAmount: Float
            var paidAmount: Float
            var discount: Float
            var discountedAmount: Float
            var change: Float

            while (true) {
                print("Enter purchase amount: ")
                try {
                    purchaseAmount = readln().toFloat()
                    if (purchaseAmount < 1) {
                        println("purchase amount must be > 0")
                    }
                    break
                } catch (e: Exception) {
                    println("purchase amount must be a float")
                }
            }

            while (true) {
                print("Enter paid amount: ")
                try {
                    paidAmount = readln().toFloat()
                    if (paidAmount < 1) {
                        println("paid amount must be > 0")
                    }
                    break
                } catch (e: Exception) {
                    println("paid amount must be a float")
                }
            }

            discount = when {
                purchaseAmount > 5000 -> 0.1f
                purchaseAmount > 1000 -> 0.05f
                else -> 0f
            }

            discountedAmount = purchaseAmount * (1 - discount)
            change = paidAmount - discountedAmount

            println("Amount to pay: ${String.format("%.2f", discountedAmount)}")

            when {
                change < 0 -> println("Need more gold ${String.format("%.2f", -change)}")
                change > 0 -> println("Take your gold ${String.format("%.2f", change)}")
                else -> println("Thank you")
            }
        }
    }
}