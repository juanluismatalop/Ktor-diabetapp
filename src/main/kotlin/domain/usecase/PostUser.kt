package domain.usecase

import domain.models.User
import domain.repository.UserInterface

class PostUser(private val repository: UserInterface) {
    fun execute(user: User) = repository.insertUser(user)
}
