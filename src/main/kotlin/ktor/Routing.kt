package ktor

import domain.usecase.LoginUseCase
import domain.usecase.RegisterUseCase
import domain.usecase.UpdateUserUseCase
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.routing.authRoutes

fun Application.configureRouting(
    loginUseCase: LoginUseCase,
    registerUseCase: RegisterUseCase,
    updateUserUseCase: UpdateUserUseCase
) {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        authRoutes(loginUseCase, registerUseCase, updateUserUseCase)

        staticResources("/static", "static")
    }
}
