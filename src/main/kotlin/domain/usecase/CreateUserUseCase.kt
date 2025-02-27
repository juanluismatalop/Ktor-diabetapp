package domain.usecase

import domain.models.User
import domain.repository.UserRepository

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): User? {
        return userRepository.createUser(user)
    }
}