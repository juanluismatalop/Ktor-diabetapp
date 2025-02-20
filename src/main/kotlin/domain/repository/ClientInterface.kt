package domain.repository

import domain.models.Client
import domain.models.UpdateClient

interface ClientInterface {
    fun getAllClient () : List <Client>

    fun postClient(client: Client) : Boolean

    fun updateClient(updateClient: UpdateClient, email:String) : Boolean

    fun deleteClient(email : String) : Boolean
}