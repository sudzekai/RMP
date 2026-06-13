class LW9 {
    companion object {

        fun task1() {
            val list = mutableListOf<String>()

            list.add("Первый")
            list.add("Второй")
            list.add("Третий")

            print("Введите n: ")
            val n = readln().toInt()

            repeat(n) {
                print("Введите значение: ")
                list.add(readln())
            }

            println("Список:")
            for (i in list.indices) {
                println("${i + 1} - ${list[i]}")
            }

            println("Количество элементов: ${list.size}")
        }

        fun task2() {
            val list = mutableListOf<Int>()

            print("Введите n: ")
            val n = readln().toInt()

            repeat(n) {
                print("Введите число: ")
                list.add(readln().toInt())
            }

            println("Индекс элемента 100: ${list.indexOf(100)}")
            println("Сумма элементов: ${list.sum()}")
            println("Среднее значение: ${list.average()}")
            println("Все числа больше 0: ${list.all { it > 0 }}")
            println("Нечетные элементы: ${list.filter { it % 2 != 0 }}")
        }

        fun task3() {
            val map = mutableMapOf<Int, String>()

            map[1] = "Один"
            map[2] = "Два"
            map[3] = "Три"

            print("Введите n: ")
            val n = readln().toInt()

            repeat(n) {
                print("Введите ключ (int): ")
                val key = readln().toInt()
                print("Введите значение: ")
                val value = readln()

                map[key] = value
            }

            println("Словарь:")
            for ((k, v) in map) {
                println("$k - $v")
            }

            println("Количество элементов: ${map.size}")
        }

        fun task4() {
            val map = mutableMapOf(
                1 to "A",
                2 to "B",
                3 to "A"
            )

            print("Введите ключ: ")
            val key = readln().toInt()

            if (map.containsKey(key)) {
                println("Найдено значение: ${map[key]}")
            } else {
                println("Ключ не найден")
            }

            print("Введите значение для подсчета: ")
            val value = readln()
            val count = map.values.count { it == value }
            println("Количество совпадений: $count")

            print("Введите ключ для удаления: ")
            val delKey = readln().toInt()
            map.remove(delKey)

            println("Словарь после удаления:")
            for ((k, v) in map) {
                println("$k - $v")
            }
        }

        fun task5() {
            val prep1 = setOf("Иванов", "Петров", "Сидоров")
            val prep2 = setOf("Петров", "Смирнов", "Иванов")

            val all = prep1 union prep2
            val both = prep1 intersect prep2
            val onlyOne = all - both

            println("Всего студентов на пересдаче: ${all.size} -> $all")
            println("Не сдали оба зачета: ${both.size} -> $both")
            println("Не сдали только один зачет: ${onlyOne.size} -> $onlyOne")
        }
    }
}