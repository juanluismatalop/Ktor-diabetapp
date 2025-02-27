package ktor.routing

import domain.usecase.LoginUseCase
import domain.usecase.RegisterUseCase
import domain.usecase.UpdateUserUseCase
import domain.models.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Route.authRoutes(
    loginUseCase: LoginUseCase,
    registerUseCase: RegisterUseCase,
    updateUserUseCase: UpdateUserUseCase
) {
    route("/auth") {
        post("/login") {
            val request = call.receive<LoginRequest>()
            val user = loginUseCase(request.usernameOrEmail, request.password)
            if (user != null) {
                call.respond(HttpStatusCode.OK, "Login successful")
            } else {
                call.respond(HttpStatusCode.Unauthorized, "Invalid credentials")
            }
        }

        post("/register") {
            val request = call.receive<RegisterRequest>()
            val user = registerUseCase(request.email, request.password)
            if (user != null) {
                call.respond(HttpStatusCode.Created, "User registered successfully")
            } else {
                call.respond(HttpStatusCode.BadRequest, "User registration failed")
            }
        }

        post("/update-profile") {
            val request = call.receive<UpdateProfileRequest>()
            val updatedUser = updateUserUseCase(
                User(
                    email = request.email,
                    password = request.password, // Opcionalmente puede no actualizarse aquí
                    ratioMannana = request.ratioMannana,
                    ratioMedioDia = request.ratioMedioDia,
                    ratioTarde = request.ratioTarde,
                    ratioNoche = request.ratioNoche,
                    factorSensibilidad = request.factorSensibilidad
                )
            )
            if (updatedUser != null) {
                call.respond(HttpStatusCode.OK, "User profile updated successfully")
            } else {
                call.respond(HttpStatusCode.BadRequest, "Failed to update profile")
            }
        }
    }
}

@Serializable
data class LoginRequest(val usernameOrEmail: String, val password: String)

@Serializable
data class RegisterRequest(val email: String, val password: String)

@Serializable
data class UpdateProfileRequest(
    val email: String,
    val password: String, // Opcional
    val ratioMannana: Double,
    val ratioMedioDia: Double,
    val ratioTarde: Double,
    val ratioNoche: Double,
    val factorSensibilidad: Double
)
