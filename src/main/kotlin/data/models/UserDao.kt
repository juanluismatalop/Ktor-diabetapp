package data.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDao>(UserTable)

    var email by UserTable.email
    var password by UserTable.password
    var ratioMannana by UserTable.ratioMannana
    var ratioMedioDia by UserTable.ratioMedioDia
    var ratioTarde by UserTable.ratioTarde
    var ratioNoche by UserTable.ratioNoche
    var factorSensibilidad by UserTable.factorSensibilidad
}
