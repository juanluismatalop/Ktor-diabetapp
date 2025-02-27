package domain.usecase

import domain.models.User
import domain.repository.UserRepository

class GetUserByUsernameOrEmailUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(usernameOrEmail: String): User? {
        return userRepository.getUserByUsernameOrEmail(usernameOrEmail)
    }
}