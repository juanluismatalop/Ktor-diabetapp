package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class UpdateClient(
    val email: String? = null,
    val contrasenna: String? = null,
    val ratioManana: Double? = null,
    val ratioMedioDia: Double? = null,
    val ratioTarde: Double? = null,
    val ratioNoche: Double? = null,
    val factorSensibilidad: Double? = null
)
