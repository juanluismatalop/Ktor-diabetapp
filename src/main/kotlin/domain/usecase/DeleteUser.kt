package domain.usecase

import domain.repository.UserInterface

class DeleteUser(private val repository: UserInterface) {
    fun execute(email: String) = repository.deleteUser(email)
}
