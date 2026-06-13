class LW8 {
    companion object {
        fun task1() {
            val human = Human("Иван", 30)
            val student = Student("Пётр", 20, "ИС-21")

            println(human)
            println(student)
        }

        fun task2() {
            val human = Human("Иван", 30)
            val student = Student("Пётр", 20, "ИС-21")

            human.printInfo()
            println(human.info)

            println()

            student.printInfo()
            println(student.info)
        }

        fun task3() {
            val rect = Rectangle(5.0, 3.0)
            rect.printInfo()
        }

        fun task4() {
            val randomSource = RandomDataSource()
            val staticSource = StaticDataSource(arrayOf(1, 2, 3))

            println("Random:")
            print10(randomSource)

            println("Static:")
            print10(staticSource)
        }

        fun task5() {
            val foodService = FoodService("DeliveryClub")
            val app = DeliveryApp(foodService)

            app.createOrder(101)
        }

        fun <T> print10(source: DataSource<T>) {
            repeat(10) {
                println(source.getNext())
            }
        }
    }

    open class Human(var name: String, var age: Int) {

        open val info: String
            get() = "Человек: имя: $name, возраст: $age"

        open fun printInfo() {
            println("Человек")
            println("Имя: $name")
            println("Возраст: $age")
        }

        override fun toString(): String {
            return "Human: name: $name, age: $age"
        }
    }

    class Student(name: String, age: Int, var group: String) : Human(name, age) {

        override val info: String
            get() = "Студент: имя: $name, возраст: $age, группа: $group"

        override fun printInfo() {
            super.printInfo()
            println("Группа: $group")
        }

        override fun toString(): String {
            return super.toString() + ", group=$group"
        }
    }

    abstract class Figure {
        abstract val name: String
        abstract fun area(): Double
        abstract fun perimeter(): Double
        abstract fun printInfo()
    }

    class Rectangle(var width: Double, var height: Double) : Figure() {

        override val name: String
            get() = "Прямоугольник"

        override fun area(): Double {
            return width * height
        }

        override fun perimeter(): Double {
            return 2 * (width + height)
        }

        override fun printInfo() {
            println(name)
            println("Ширина: $width")
            println("Высота: $height")
            println("Площадь: ${area()}")
            println("Периметр: ${perimeter()}")
        }
    }

    interface DataSource<T> {
        fun getNext(): T
    }

    class RandomDataSource : DataSource<Int> {
        override fun getNext(): Int {
            return (0..100).random()
        }
    }

    class StaticDataSource<T>(
        private val data: Array<T>
    ) : DataSource<T> {

        private var index = 0

        override fun getNext(): T {
            val value = data[index]
            index = (index + 1) % data.size
            return value
        }
    }

    interface DeliveryService {
        val serviceName: String
        fun deliver(orderId: Int)
    }

    class FoodService(
        override val serviceName: String
    ) : DeliveryService {

        override fun deliver(orderId: Int) {
            println("Заказ $orderId передан в доставку через $serviceName")
        }
    }

    class DeliveryApp(
        private val service: DeliveryService
    ) : DeliveryService by service {

        fun createOrder(orderId: Int) {
            println("Создан заказ $orderId")
            deliver(orderId)
        }
    }
}