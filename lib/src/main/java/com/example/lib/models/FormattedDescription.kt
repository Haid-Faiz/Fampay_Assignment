package com.example.lib.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FormattedDescription(
    @SerialName("entities")
    var entities: List<Entity?>? = null,
    @SerialName("text")
    var text: String? = null
)
