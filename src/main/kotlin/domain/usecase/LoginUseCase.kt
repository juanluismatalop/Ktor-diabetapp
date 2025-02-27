package domain.usecase

import domain.models.User
import domain.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(usernameOrEmail: String, password: String): User? {
        return userRepository.login(usernameOrEmail, password)
    }
}