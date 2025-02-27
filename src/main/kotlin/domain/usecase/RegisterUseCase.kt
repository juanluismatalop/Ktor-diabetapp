package domain.usecase

import domain.models.User
import domain.repository.UserRepository

class RegisterUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String, password: String): User? {
        val existingUser = userRepository.getUserByUsernameOrEmail(email)
        if (existingUser != null) {
            throw IllegalArgumentException("El usuario ya existe")
        }

        val newUser = User(
            email = email,
            password = password,
            ratioMannana = 0.0,
            ratioMedioDia = 0.0,
            ratioTarde = 0.0,
            ratioNoche = 0.0,
            factorSensibilidad = 0.0
        )

        return userRepository.createUser(newUser)
    }
}
