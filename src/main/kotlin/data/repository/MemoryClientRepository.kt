package data.repository

import data.models.ClientData
import domain.models.Client
import domain.models.UpdateClient
import domain.repository.ClientInterface

class MemoryClientRepository : ClientInterface {

    override fun getAllClient(): List<Client> {
        return ClientData.listClient
    }

    override fun postClient(client: Client): Boolean {
        val cli = ClientData.listClient.find { it.email == client.email }
        return if (cli != null) {
            false
        } else {
            ClientData.listClient.add(client)
            true
        }
    }

    override fun updateClient(updateClient: UpdateClient, email: String): Boolean {
        val index = ClientData.listClient.indexOfFirst { it.email == email }
        return if (index != -1) {
            val originClient = ClientData.listClient[index]
            ClientData.listClient[index] = originClient.copy(
                contrasenna = updateClient.contrasenna ?: originClient.contrasenna,
                ratioManana = updateClient.ratioManana ?: originClient.ratioManana,
                ratioMedioDia = updateClient.ratioMedioDia ?: originClient.ratioMedioDia,
                ratioTarde = updateClient.ratioTarde ?: originClient.ratioTarde,
                ratioNoche = updateClient.ratioNoche ?: originClient.ratioNoche,
                factorSensibilidad = updateClient.factorSensibilidad ?: originClient.factorSensibilidad
            )
            true
        } else {
            false
        }
    }

    override fun deleteClient(email: String): Boolean {
        val index = ClientData.listClient.indexOfFirst { it.email == email }
        return if (index != -1) {
            ClientData.listClient.removeAt(index)
            true
        } else {
            false
        }
    }
}
