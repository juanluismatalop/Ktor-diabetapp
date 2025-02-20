package domain.usecase

import domain.models.Client
import domain.repository.ClientInterface

class PostClienteUseCase (val repository : ClientInterface){

    var client : Client? = null

    operator fun invoke() : Boolean {
        return if (client == null) {
            false
        }else {
            repository.postClient(client!!)
        }
    }
}