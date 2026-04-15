data class MongoClient (
    val url: String,
    val port: Int,
    val database: String
)

object MongoDBClientFactory {
    fun createClient(url: String, port: Int, database: String): MongoClient {
        return MongoClient(url, port, database)
    }
}

fun main() {
    val client = MongoDBClientFactory.createClient("localhost", 27017, "mydb")
    println(client)
}

