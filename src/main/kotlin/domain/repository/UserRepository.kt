package domain.repository

import domain.models.User

interface UserRepository {
    suspend fun createUser(user: User): User?
    suspend fun getUserByUsernameOrEmail(usernameOrEmail: String): User?
    suspend fun updateUser(user: User): User?
    suspend fun deleteUser(userId: String): Boolean
    suspend fun login(usernameOrEmail: String, password: String): User?
}
