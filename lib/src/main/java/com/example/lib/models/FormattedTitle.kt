package com.example.lib.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FormattedTitle(
    @SerialName("align")
    var align: String? = "",
    @SerialName("entities")
    var entities: List<Entity>? = listOf(),
    @SerialName("text")
    var text: String? = ""
)
