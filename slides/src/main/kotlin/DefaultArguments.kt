data class User(
    val name: String,
    val age: Int = 0,
    val city: String = "A Coruña",
    val active: Boolean = true
)

fun greet(message: String, name: String = "Coruña JUG") = println("$message $name")

fun main() {
    greet("Hola")
    greet(message = "Hola", name = "Mundo")
    greet(name = "Mundo", message = "Hola")

    // User.builder()
    //     .name("Tanis")
    //     .city("Madrid")
    //     .build();

    val user1 = User("Sofía")
    val user2 = User(name = "Pepe", age = 42)
    val user3 = User(
        name = "María",
        city = "Vilagarcía de Arousa",
        active = false
    )

    println(user1)
}
