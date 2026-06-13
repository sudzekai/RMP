import kotlinx.coroutines.*
import kotlin.random.Random

class LW10 {
    companion object {
        suspend fun sheep() {
            for (i in 1..500) {
                println("$i овечка (${Thread.currentThread().name})")
            }
            delay(1000)
            for (i in 501..1000) {
                println("$i овечка (${Thread.currentThread().name})")
            }
        }

        suspend fun cats() {
            for (i in 1..500) {
                println("$i котик (${Thread.currentThread().name})")
                delay(10)
            }
        }

        fun task1() = runBlocking {
            println("Main поток: ${Thread.currentThread().name}")

            val job1 = launch {
                sheep()
            }

            val job2 = launch {
                cats()
            }

            joinAll(job1, job2)
        }

        suspend fun loadFiles() {
            try {
                for (i in 1..30) {
                    println("Загрузка файла $i (${Thread.currentThread().name})")
                    delay(3000)
                }
                println("Все файлы загружены")
            } catch (e: CancellationException) {
                println("Загрузка отменена")
            }
        }

        fun task2() = runBlocking {
            val job = launch(Dispatchers.IO) {
                loadFiles()
            }

            println("Введите cancel для остановки:")
            val input = readln()

            if (input == "cancel") {
                job.cancel()
            }

            job.join()
        }

        suspend fun connectDB() {
            repeat(5) {
                println("Попытка подключения к БД (${Thread.currentThread().name})")
                delay(3000)
            }
        }

        fun task3() = runBlocking {
            try {
                withTimeout(10000) {
                    connectDB()
                }
            } catch (e: TimeoutCancellationException) {
                println("Превышено время ожидания")
            }
        }

        suspend fun connectWeb(): Int {
            println("Подключение к веб-серверу (${Thread.currentThread().name})")
            delay(1000)

            val codes = listOf(200, 400, 401, 403, 404, 410, 500)
            return codes.random()
        }

        fun task4() = runBlocking {
            println("Main поток: ${Thread.currentThread().name}")

            val job1 = launch {
                sheep()
            }

            val job2 = launch(Dispatchers.IO) {
                cats()
            }

            joinAll(job1, job2)
        }

        fun task5() = runBlocking {
            val deferred: Deferred<Int> = async {
                connectWeb()
            }

            val result = deferred.await()
            println("HTTP статус: $result")
        }

    }
}