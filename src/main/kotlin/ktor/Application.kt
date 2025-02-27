package ktor

import com.ktor.configureSerialization


import data.repository.UserRepositoryImpl
import domain.repository.UserRepository
import domain.usecase.LoginUseCase
import domain.usecase.RegisterUseCase
import domain.usecase.UpdateUserUseCase
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val config = environment.config

    val dbDriver = config.property("ktor.database.driver").getString()
    val dbUrl = config.property("ktor.database.url").getString()
    val dbUser = config.property("ktor.database.user").getString()
    val dbPassword = config.property("ktor.database.password").getString()

    configureSerialization()
    configureDatabase(dbDriver, dbUrl, dbUser, dbPassword)

    val userRepository: UserRepository = UserRepositoryImpl()
    val loginUseCase = LoginUseCase(userRepository)
    val registerUseCase = RegisterUseCase(userRepository)
    val updateUserUseCase = UpdateUserUseCase(userRepository)

    configureRouting(loginUseCase, registerUseCase, updateUserUseCase)
}

