package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val password: String,
    val morningRatio: Float,
    val noonRatio: Float,
    val afternoonRatio: Float,
    val nightRatio: Float,
    val sensitivityFactor: Float
)
