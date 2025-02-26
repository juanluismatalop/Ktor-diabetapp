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
        get("/clients") {
            val clients = clientRepository.getAllClient()
            if (clients.isEmpty()) {
                call.respond(HttpStatusCode.NotFound, "No hay clientes registrados.")
            } else {
                call.respond(HttpStatusCode.OK, clients)
            }
        }

        post("/clients") {
            val client = call.receive<Client>()
            val result = clientRepository.postClient(client)
            if (result) {
                call.respond(HttpStatusCode.Created, "Cliente agregado exitosamente.")
            } else {
                call.respond(HttpStatusCode.Conflict, "El cliente ya existe.")
            }
        }

        put("/clients/{email}") {
            val email = call.parameters["email"]
            if (email.isNullOrBlank()) {
                call.respond(HttpStatusCode.BadRequest, "Email es requerido.")
                return@put
            }
            val updateClient = call.receive<UpdateClient>()
            val result = clientRepository.updateClient(updateClient, email)
            if (result) {
                call.respond(HttpStatusCode.OK, "Cliente actualizado exitosamente.")
            } else {
                call.respond(HttpStatusCode.NotFound, "Cliente no encontrado.")
            }
        }

        delete("/clients/{email}") {
            val email = call.parameters["email"]
            if (email.isNullOrBlank()) {
                call.respond(HttpStatusCode.BadRequest, "Email es requerido.")
                return@delete
            }
            val result = clientRepository.deleteClient(email)
            if (result) {
                call.respond(HttpStatusCode.OK, "Cliente eliminado exitosamente.")
            } else {
                call.respond(HttpStatusCode.NotFound, "Cliente no encontrado.")
            }
        }

        post("/register") {
            val client = call.receive<Client>()
            val exists = clientRepository.getAllClient().any { it.email == client.email }
            if (exists) {
                call.respond(HttpStatusCode.Conflict, "El usuario ya está registrado.")
            } else {
                clientRepository.postClient(client)
                call.respond(HttpStatusCode.Created, "Registro exitoso.")
            }
        }

        post("/login") {
            val credentials = call.receive<Client>()
            val client = clientRepository.getAllClient().find { it.email == credentials.email }
            if (client == null || client.contrasenna != credentials.contrasenna) {
                call.respond(HttpStatusCode.Unauthorized, "Email o contraseña incorrectos.")
            } else {
                call.respond(HttpStatusCode.OK, "Inicio de sesión exitoso.")
            }
        }
    }
}
