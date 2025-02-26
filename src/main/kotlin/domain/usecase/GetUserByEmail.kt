package domain.usecase

import domain.models.User
import domain.repository.UserInterface

class GetUserByEmail(private val repository: UserInterface) {
    fun execute(email: String): User? = repository.getUserByEmail(email)
}
