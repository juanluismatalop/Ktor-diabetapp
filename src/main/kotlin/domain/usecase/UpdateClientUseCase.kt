package domain.usecase

import domain.models.UpdateClient
import domain.repository.ClientInterface

class UpdateClientUseCase (val repository : ClientInterface){
    var updateClient: UpdateClient? = null
    var email: String? = null

    operator fun invoke() : Boolean {
        return if (updateClient == null || email == null) {
            false
        }else{
            return repository.updateClient(updateClient!!, email!!)
        }

    }
}