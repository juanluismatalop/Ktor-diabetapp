package domain.usecase

import domain.models.Client
import domain.repository.ClientInterface

class GetAllClientUseCase (val repository : ClientInterface){

    operator fun invoke(): List<Client> = repository.getAllClient()
}