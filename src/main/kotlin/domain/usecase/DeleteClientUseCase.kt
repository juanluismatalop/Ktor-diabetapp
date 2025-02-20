package domain.usecase

import domain.repository.ClientInterface

class DeleteClientUseCase (val repository : ClientInterface){
    var email: String? = null

    operator fun invoke() : Boolean {
        return if (email == null) {
            false
        }else{
            return repository.deleteClient(email!!)
        }

    }
}