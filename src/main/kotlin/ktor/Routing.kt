package ktor.routes

import domain.models.User
import domain.usecase.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRoutes(
    postUser: PostUser,
    getUserByEmail: GetUserByEmail,
    updateUser: UpdateUser,
    deleteUser: DeleteUser
) {
    route("/user") {
        post("/register") {
            val user = call.receive<User>()
            postUser.execute(user)
            call.respondText("User registered successfully")
        }

        get("/{email}") {
            val email = call.parameters["email"] ?: return@get call.respondText("Missing email")
            val user = getUserByEmail.execute(email) ?: return@get call.respondText("User not found")
            call.respond(user)
        }

        put("/{email}") {
            val email = call.parameters["email"] ?: return@put call.respondText("Missing email")
            val updatedUser = call.receive<User>()
            updateUser.execute(updatedUser)
            call.respondText("User updated successfully")
        }

        delete("/{email}") {
            val email = call.parameters["email"] ?: return@delete call.respondText("Missing email")
            deleteUser.execute(email)
            call.respondText("User deleted successfully")
        }
    }
}
