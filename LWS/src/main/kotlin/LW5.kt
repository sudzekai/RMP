class LW5 {
    companion object {
        fun task1() {
            println("\n(1)")
            var step: Int

            while (true) {
                print("Введите шаг: ")
                try {
                    step = readln().toInt()
                    if (step < 1) {
                        println("Шаг должен быть больше 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Введите целое число")
                }
            }
            println("|    °C      |     °F     |")

            for (celsius in 100 downTo -50 step step) {
                val fahrenheit = celsius * 1.8 + 32
                println("| %-8d   | %-9.2f  |".format(celsius, fahrenheit))
            }

            println("\n(2)")
            var a: Float
            var b: Float
            var x1: Int
            var x2: Int

            while (true) {
                print("Введите a: ")
                try {
                    a = readln().toFloat()
                    break
                } catch (e: Exception) {
                    println("Введите вещественное число")
                }
            }

            while (true) {
                print("Введите b: ")
                try {
                    b = readln().toFloat()
                    break
                } catch (e: Exception) {
                    println("Введите вещественное число")
                }
            }

            while (true) {
                print("Введите x1: ")
                try {
                    x1 = readln().toInt()
                    break
                } catch (e: Exception) {
                    println("Введите целое число")
                }
            }

            while (true) {
                print("Введите x2: ")
                try {
                    x2 = readln().toInt()
                    break
                } catch (e: Exception) {
                    println("Введите целое число")
                }
            }

            val start = minOf(x1, x2)
            val end = maxOf(x1, x2)

            println("x\ty(x)")

            for (x in start..end) {
                val y = a * x + b
                println("$x\t$y")
            }
        }

        fun task2() {
            println("\n(1)")

            print("\t")
            for (i in 0..9) {
                print("$i\t")
            }
            println()

            for (i in 1..9) {
                print("$i\t")
                for (j in 0..9) {
                    val num = i * 10 + j
                    print("${num * num}\t")
                }
                println()
            }

            println("\n(2)")

            print("\t")
            for (i in 1..9) {
                print("$i\t")
            }
            println()

            for (i in 1..9) {
                print("$i\t")
                for (j in 1..9) {
                    print("${i * j}\t")
                }
                println()
            }
        }

        fun task3() {
            println("\n(1)")

            var a: Float
            while (true) {
                print("Введите делимое a: ")
                try {
                    a = readln().toFloat()
                    break
                } catch (e: Exception) {
                    println("Введите число")
                }
            }

            var b: Float
            while (true) {
                print("Введите делитель b: ")
                try {
                    b = readln().toFloat()
                    if (b == 0f) {
                        println("Делитель не может быть равен 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Введите число")
                }
            }

            val result = a / b
            println("$a / $b = $result")

            println("\n(2)")

            var sum: Float
            while (true) {
                print("Введите сумму вклада: ")
                try {
                    sum = readln().toFloat()
                    if (sum <= 0) {
                        println("Сумма должна быть больше 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Введите число")
                }
            }

            var percent: Float
            while (true) {
                print("Введите процент годовых: ")
                try {
                    percent = readln().toFloat()
                    if (percent <= 0) {
                        println("Процент должен быть больше 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Введите число")
                }
            }

            var years = 0
            var money = sum

            while (money < 1000000f) {
                money += money * percent / 100
                years++
                println("Год $years: $money")
            }
        }

        fun task4() {
            println("\n(1)")

            var sum: Float
            while (true) {
                print("Введите сумму покупки: ")
                try {
                    sum = readln().toFloat()
                    if (sum <= 0) {
                        println("Сумма должна быть больше 0")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Введите число")
                }
            }

            var paid: Float
            while (true) {
                print("Введите внесенную сумму: ")
                try {
                    paid = readln().toFloat()
                    if (paid < 0) {
                        println("Сумма не может быть отрицательной")
                        continue
                    }
                    break
                } catch (e: Exception) {
                    println("Введите число")
                }
            }

            do {
                if (paid < sum) {
                    val need = sum - paid
                    println("Недостаточно. Не хватает $need")
                    while (true) {
                        print("Введите недостающую сумму: ")
                        try {
                            val extra = readln().toFloat()
                            if (extra <= 0) {
                                println("Сумма должна быть больше 0")
                                continue
                            }
                            paid += extra
                            break
                        } catch (e: Exception) {
                            println("Введите число")
                        }
                    }
                }
            } while (paid < sum)

            when {
                paid == sum -> println("Спасибо!")
                paid > sum -> println("Возьмите сдачу ${paid - sum}")
            }

            println("\n(2)")

            val secret = (1..10).random()
            var guess: Int

            do {
                print("Угадайте число от 1 до 10: ")
                try {
                    guess = readln().toInt()
                    when {
                        guess < secret -> println("Требуется ввести большее число")
                        guess > secret -> println("Требуется ввести меньшее число")
                        else -> println("Молодец!")
                    }
                } catch (e: Exception) {
                    println("Введите целое число")
                    guess = 0
                }
            } while (guess != secret)
        }
    }
}