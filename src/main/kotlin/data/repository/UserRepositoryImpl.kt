package data.repository

import data.models.UserDao
import data.models.UserTable
import data.persistence.suspendTransaction
import domain.models.User
import domain.repository.UserRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class UserRepositoryImpl : UserRepository {
    override suspend fun createUser(user: User): User? {
        return suspendTransaction {
            val userId = UserTable.insertAndGetId {
                it[email] = user.email
                it[password] = user.password
                it[ratioMannana] = user.ratioMannana
                it[ratioMedioDia] = user.ratioMedioDia
                it[ratioTarde] = user.ratioTarde
                it[ratioNoche] = user.ratioNoche
                it[factorSensibilidad] = user.factorSensibilidad
            }.value
            getUserById(userId)
        }
    }

    override suspend fun getUserByUsernameOrEmail(usernameOrEmail: String): User? {
        return suspendTransaction {
            UserDao.find { UserTable.email eq usernameOrEmail }
                .firstOrNull()
                ?.let { userDao ->
                    User(
                        email = userDao.email,
                        password = userDao.password,
                        ratioMannana = userDao.ratioMannana,
                        ratioMedioDia = userDao.ratioMedioDia,
                        ratioTarde = userDao.ratioTarde,
                        ratioNoche = userDao.ratioNoche,
                        factorSensibilidad = userDao.factorSensibilidad
                    )
                }
        }
    }

    override suspend fun updateUser(user: User): User? {
        return suspendTransaction {
            UserTable.update({ UserTable.email eq user.email }) {
                it[password] = user.password
                it[ratioMannana] = user.ratioMannana
                it[ratioMedioDia] = user.ratioMedioDia
                it[ratioTarde] = user.ratioTarde
                it[ratioNoche] = user.ratioNoche
                it[factorSensibilidad] = user.factorSensibilidad
            }

            UserDao.find { UserTable.email eq user.email }
                .firstOrNull()
                ?.let { userDao ->
                    User(
                        email = userDao.email,
                        password = userDao.password,
                        ratioMannana = userDao.ratioMannana,
                        ratioMedioDia = userDao.ratioMedioDia,
                        ratioTarde = userDao.ratioTarde,
                        ratioNoche = userDao.ratioNoche,
                        factorSensibilidad = userDao.factorSensibilidad
                    )
                }
        }
    }

    override suspend fun deleteUser(userId: String): Boolean {
        return suspendTransaction {
            val id = userId.toIntOrNull() ?: return@suspendTransaction false
            UserTable.deleteWhere { UserTable.id eq id } > 0
        }
    }

    override suspend fun login(usernameOrEmail: String, password: String): User? {
        return suspendTransaction {
            UserDao.find { (UserTable.email eq usernameOrEmail) and (UserTable.password eq password) }
                .firstOrNull()
                ?.let { userDao ->
                    User(
                        email = userDao.email,
                        password = userDao.password,
                        ratioMannana = userDao.ratioMannana,
                        ratioMedioDia = userDao.ratioMedioDia,
                        ratioTarde = userDao.ratioTarde,
                        ratioNoche = userDao.ratioNoche,
                        factorSensibilidad = userDao.factorSensibilidad
                    )
                }
        }
    }

    private fun getUserById(id: Int): User? {
        return UserDao.findById(id)?.let { userDao ->
            User(
                email = userDao.email,
                password = userDao.password,
                ratioMannana = userDao.ratioMannana,
                ratioMedioDia = userDao.ratioMedioDia,
                ratioTarde = userDao.ratioTarde,
                ratioNoche = userDao.ratioNoche,
                factorSensibilidad = userDao.factorSensibilidad
            )
        }
    }
}
