package com.ktor

import data.repository.MemoryClientRepository
import domain.models.Client
import domain.models.UpdateClient
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val clientRepository = MemoryClientRepository()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/client") {
            val clients = clientRepository.getAllClient()
            if (clients.isEmpty()) {
                call.respond(HttpStatusCode.NotFound, "Clientes no encontrados")
            } else {
                call.respond(HttpStatusCode.OK, clients)
            }
        }

        post("/client") {
            val client = call.receive<Client>()
            val result = clientRepository.postClient(client)
            if (result) {
                call.respond(HttpStatusCode.Created, "Cliente agregado exitosamente")
            } else {
                call.respond(HttpStatusCode.Conflict, "El cliente ya existe")
            }
        }

        put("/client") {
            val email = call.parameters["email"]
            if (email.isNullOrBlank()) {
                call.respond(HttpStatusCode.BadRequest, "Email es requerido")
                return@put
            }
            val updateClient = call.receive<UpdateClient>()
            val result = clientRepository.updateClient(updateClient, email)
            if (result) {
                call.respond(HttpStatusCode.OK, "Cliente actualizado exitosamente")
            } else {
                call.respond(HttpStatusCode.NotFound, "Cliente no encontrado")
            }
        }

        delete("/client/{email}") {
            val email = call.parameters["email"]
            if (email.isNullOrBlank()) {
                call.respond(HttpStatusCode.BadRequest, "Email es requerido")
                return@delete
            }
            val result = clientRepository.deleteClient(email)
            if (result) {
                call.respond(HttpStatusCode.OK, "Cliente eliminado exitosamente")
            } else {
                call.respond(HttpStatusCode.NotFound, "Cliente no encontrado")
            }
        }
    }
}
