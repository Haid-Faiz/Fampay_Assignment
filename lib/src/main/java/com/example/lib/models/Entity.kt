package com.example.lib.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Entity(
    @SerialName("color")
    var color: String? = null,
    @SerialName("text")
    var text: String? = null
)
