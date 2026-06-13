class LW7 {
    companion object {
        fun task1() {
            val t1 = Train(101)
            t1.departure = "Москва"
            t1.arrival = "Санкт-Петербург"
            t1.wagons = 10
            t1.printInfo()
        }

        fun task2() {
            val t2 = Train(202, "Казань", "Самара", 8)
            t2.printInfo()
        }

        fun task3() {
            val t2 = Train(202, "Казань", "Самара", 8)
            println(t2.wagonsInfo)
        }

        fun task4() {
            val t2 = Train(202, "Казань", "Самара", 8)
            t2.wagons = -5      // ошибка
            t2.departure = ""   // ошибка
        }

        fun task5() {
            val trains = arrayOf(
                Train(1, "A", "B", 5),
                Train(2, "C", "D", 12),
                Train(3, "E", "F", 8)
            )

            println("Поезда с количеством вагонов > 7:")
            for (t in trains) {
                if (t.wagons > 7) {
                    t.printInfo()
                }
            }
        }
    }

    class Train(number: Int) {

        var number: Int = number
            set(value) {
                if (value < 0) {
                    println("Ошибка: номер не может быть отрицательным")
                } else {
                    field = value
                }
            }

        var departure: String = ""
            set(value) {
                if (value.length < 1) {
                    println("Ошибка: пункт отправления не может быть пустым")
                } else {
                    field = value
                }
            }

        var arrival: String = ""
            set(value) {
                if (value.isEmpty()) {
                    println("Ошибка: пункт прибытия не может быть пустым")
                } else {
                    field = value
                }
            }

        var wagons: Int = 0
            set(value) {
                if (value < 0) {
                    println("Ошибка: количество вагонов не может быть отрицательным")
                } else {
                    field = value
                }
            }

        constructor(number: Int, departure: String, arrival: String, wagons: Int) : this(number) {
            this.departure = departure
            this.arrival = arrival
            this.wagons = wagons
        }

        fun printInfo() {
            println("Поезд №$number: $departure -> $arrival, вагонов: $wagons")
        }

        val wagonsInfo: String
            get() = "Количество вагонов: $wagons"
    }
}