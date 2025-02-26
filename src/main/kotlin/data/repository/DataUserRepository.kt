package data.repository

import data.models.UserData
import domain.models.User
import domain.repository.UserInterface
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DataUserRepository : UserInterface {

    override fun getAllUsers(): List<User> = transaction {
        UserData.selectAll().map {
            User(
                email = it[UserData.email],
                password = it[UserData.password],
                morningRatio = it[UserData.morningRatio],
                noonRatio = it[UserData.noonRatio],
                afternoonRatio = it[UserData.afternoonRatio],
                nightRatio = it[UserData.nightRatio],
                sensitivityFactor = it[UserData.sensitivityFactor]
            )
        }
    }

    override fun getUserByEmail(email: String): User? = transaction {
        UserData.select { UserData.email eq email }
            .map {
                User(
                    email = it[UserData.email],
                    password = it[UserData.password],
                    morningRatio = it[UserData.morningRatio],
                    noonRatio = it[UserData.noonRatio],
                    afternoonRatio = it[UserData.afternoonRatio],
                    nightRatio = it[UserData.nightRatio],
                    sensitivityFactor = it[UserData.sensitivityFactor]
                )
            }.singleOrNull()
    }

    override fun insertUser(user: User) {
        UserData.insert {
            it[email] = user.email
            it[password] = user.password
            it[morningRatio] = user.morningRatio
            it[noonRatio] = user.noonRatio
            it[afternoonRatio] = user.afternoonRatio
            it[nightRatio] = user.nightRatio
            it[sensitivityFactor] = user.sensitivityFactor
        }
    }

    override fun updateUser(user: User) = transaction {
        UserData.update({ UserData.email eq user.email }) {
            it[password] = user.password
            it[morningRatio] = user.morningRatio
            it[noonRatio] = user.noonRatio
            it[afternoonRatio] = user.afternoonRatio
            it[nightRatio] = user.nightRatio
            it[sensitivityFactor] = user.sensitivityFactor
        }
    }

    override fun deleteUser(email: String) = transaction {
        UserData.deleteWhere { UserData.email eq email }
    }
}
