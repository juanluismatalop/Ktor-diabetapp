package domain.usecase

import domain.models.User
import domain.repository.UserInterface

class GetAllUsers(private val repository: UserInterface) {
    fun execute(): List<User> = repository.getAllUsers()
}
