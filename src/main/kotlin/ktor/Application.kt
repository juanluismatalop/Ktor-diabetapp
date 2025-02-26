package ktor

import data.repository.DataUserRepository
import domain.usecase.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import ktor.routes.userRoutes

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val userRepository = DataUserRepository()

    val postUser = PostUser(userRepository)
    val getUserByEmail = GetUserByEmail(userRepository)
    val updateUser = UpdateUser(userRepository)
    val deleteUser = DeleteUser(userRepository)

    routing {
        userRoutes(postUser, getUserByEmail, updateUser, deleteUser)
    }
}
