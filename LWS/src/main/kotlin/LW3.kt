class LW3 {
    companion object {
        fun task1() {
            var a: Int
            while (true) {
                print("Enter num a:")
                try {
                    a = readln().toInt()
                    break
                } catch (e: Exception) {
                    println("a must be an int")
                }
            }

            var b: Int
            while (true) {
                print("Enter num b:")
                try {
                    b = readln().toInt()
                    break
                } catch (e: Exception) {
                    println("b must be an int")
                }
            }

            println("$a+$b=${a + b}")
            println("$a-$b=${a - b}")
            println("$a*$b=${a * b}")
            println("$a/$b=${String.format("%.2f", a.toDouble() / b)}")
            println("$a%$b=${a % b}")
        }

        fun task2() {
            print("Enter ur name:")
            val name = readln()

            var height: Int
            while (true) {
                print("Enter ur height in cm:")
                try {
                    height = readln().toInt()
                    break
                } catch (e: Exception) {
                    println("height must be an int")
                }
            }

            var weight: Float
            while (true) {
                print("Enter ur weight:")
                try {
                    weight = readln().toFloat()
                    break
                } catch (e: Exception) {
                    println("weight must be a float")
                }
            }

            val bmi = weight / ((height / 100.0) * (height / 100.0))
            println("$name, ur BMI ${String.format("%.2f", bmi)}")
        }

        fun task3() {
            print("Enter seconds: ")
            val n = readln().toInt()

            val secondsInDay = 24 * 3600
            val remaining = n % secondsInDay

            val hours = remaining / 3600
            val minutes = (remaining % 3600) / 60
            val seconds = remaining % 60

            println(String.format("%02d:%02d:%02d", hours, minutes, seconds))
        }

        fun task4() {
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

            val isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

            println(isLeap)
        }

        fun task5() {
            var outerRadius: Float
            var innerRadius: Float

            while (true) {
                while (true) {
                    print("Enter outer radius: ")
                    try {
                        outerRadius = readln().toFloat()
                        break
                    } catch (e: Exception) {
                        println("Outer radius must be a float")
                    }
                }

                while (true) {
                    print("Enter inner radius: ")
                    try {
                        innerRadius = readln().toFloat()
                        break
                    } catch (e: Exception) {
                        println("Inner radius must be a float")
                    }
                }

                if (innerRadius > outerRadius) {
                    println("inner radius cannot be greater than outer radius")
                } else {
                    break
                }
            }

            val ringArea = Math.PI.toFloat() * (outerRadius * outerRadius - innerRadius * innerRadius)

            println(String.format("Ring area: %.3f", ringArea))
        }

    }

}