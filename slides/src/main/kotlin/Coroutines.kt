import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun fetchUser(): String {
    delay(1000)
    return "User"
}

suspend fun fetchOrders(): String {
    delay(1000)
    return "Orders"
}

suspend fun fetchRecommendations(): String {
    delay(1000)
    return "Recommendations"
}

fun main() = runBlocking {

    val time = measureTimeMillis {
        val user = async { fetchUser() }
        val orders = async { fetchOrders() }
        val recommendations = async { fetchRecommendations() }

        println(user.await())
        println(orders.await())
        println(recommendations.await())
    }

    println("Time: $time ms")
}
