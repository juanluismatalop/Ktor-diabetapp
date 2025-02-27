package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val password: String,
    val ratioMannana: Double,
    val ratioMedioDia: Double,
    val ratioTarde: Double,
    val ratioNoche: Double,
    val factorSensibilidad: Double
)
