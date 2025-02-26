package domain.usecase

import domain.repository.ClientInterface

class DeleteClientUseCase(private val repository: ClientInterface) {

    operator fun invoke(email: String?): Boolean {
        if (email.isNullOrBlank()) {
            return false
        }
        return repository.deleteClient(email)
    }
}
