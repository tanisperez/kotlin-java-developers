import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun fetch(): String {
    delay(1000)
    return "ok"
}

fun main() {
    runBlocking {
         launch {
             println(fetch())
         }
    }
}
