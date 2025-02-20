package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Client(
    val email: String,
    val contrasenna: String,
    val ratioManana: Double,
    val ratioMedioDia: Double,
    val ratioTarde: Double,
    val ratioNoche: Double,
    val factorSensibilidad: Double
)
