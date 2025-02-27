package data.models

import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable : IntIdTable("users") {
    val email = varchar("email", 100).uniqueIndex()
    val password = varchar("password", 100)
    val ratioMannana = double("ratioMannana")
    val ratioMedioDia = double("ratioMedioDia")
    val ratioTarde = double("ratioTarde")
    val ratioNoche = double("ratioNoche")
    val factorSensibilidad = double("factorSensibilidad")

}