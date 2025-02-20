package data.repository

import domain.models.Client
import domain.models.UpdateClient
import domain.repository.ClientInterface

class DataClientRepository : ClientInterface{
    override fun getAllClient(): List<Client> {
        TODO("Not yet implemented")
    }

    override fun postClient(client: Client): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateClient(updateClient: UpdateClient, email: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteClient(email: String): Boolean {
        TODO("Not yet implemented")
    }
}