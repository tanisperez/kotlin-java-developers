package fp

fun main() {
    val result = listOf(1, 2, 3, 4)
        .filter { x -> x % 2 == 0 }
        .map { x -> x * 2 }

    println(result)
}
