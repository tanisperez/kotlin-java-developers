import java.util.*

data class DB2Config (
    val jdbcUrl: String,
    val username: String,
    val password: String
)

data class DB2Connection (
    val isAlive: Boolean,
    val dB2Config: DB2Config
)

object DB2DataSourceManager {

    private val dB2Config: DB2Config by lazy {
        val properties = Properties()

        DB2DataSourceManager::class.java
            .getResourceAsStream("/db2.properties")
            ?.use { properties.load(it) }
            ?: error("db2.properties not found")

        DB2Config(
            jdbcUrl = properties.getProperty("JDBC_URL"),
            username = properties.getProperty("JDBC_USER"),
            password = properties.getProperty("JDBC_PASSWORD")
        )
    }

    fun getConnection() : DB2Connection = DB2Connection(true, dB2Config)

}

fun main() {
    val connection = DB2DataSourceManager.getConnection()
    println(connection)
}

