package data.models

import org.jetbrains.exposed.sql.Table

object UserData : Table("users") {
    val email = varchar("email", 255)
    val password = varchar("password", 255)
    val morningRatio = float("morning_ratio")
    val noonRatio = float("noon_ratio")
    val afternoonRatio = float("afternoon_ratio")
    val nightRatio = float("night_ratio")
    val sensitivityFactor = float("sensitivity_factor")

    override val primaryKey = PrimaryKey(email, name = "PK_User_Email")
}

