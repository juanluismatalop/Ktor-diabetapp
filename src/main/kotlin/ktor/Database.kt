package ktor
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import data.models.UserTable
import org.jetbrains.exposed.sql.Database

fun configureDatabase(driver: String, url: String, user: String, password: String) {
    Database.connect(
        url = url,
        driver = driver,
        user = user,
        password = password
    )

    // Aseguramos que las tablas se crean al iniciar
    transaction {
        SchemaUtils.createMissingTablesAndColumns(UserTable)
    }
}

