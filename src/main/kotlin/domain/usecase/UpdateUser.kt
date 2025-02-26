package domain.usecase

import domain.models.User
import domain.repository.UserInterface

class UpdateUser(private val repository: UserInterface) {
    fun execute(user: User) = repository.updateUser(user)
}
