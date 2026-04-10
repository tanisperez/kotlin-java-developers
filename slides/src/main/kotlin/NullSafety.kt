fun main() {
    val name: String? = null

    println(name ?: "valor por defecto")
    println(name?.length)
    println(name?.length ?: 0)

    var other: String = "test"
    // other = null // ❌ No compila
    println(other)
}
