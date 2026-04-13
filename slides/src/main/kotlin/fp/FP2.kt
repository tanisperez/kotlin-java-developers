package fp

fun main() {
    val sum: (Int, Int) -> Int = { a, b -> a + b }

    println(sum(1, 2))
}
