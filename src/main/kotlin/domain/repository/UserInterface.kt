package domain.repository

import domain.models.User

interface UserInterface {
    fun getAllUsers(): List<User>
    fun getUserByEmail(email: String): User?
    fun insertUser(user: User)
    fun updateUser(user: User)
    fun deleteUser(email: String)
}
