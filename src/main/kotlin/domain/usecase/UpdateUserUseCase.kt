package domain.usecase

import domain.models.User
import domain.repository.UserRepository

class UpdateUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): User? {
        return userRepository.updateUser(user)
    }
}
