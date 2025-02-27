package domain.usecase

import domain.repository.UserRepository

class DeleteUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(userId: String): Boolean {
        return userRepository.deleteUser(userId)
    }
}