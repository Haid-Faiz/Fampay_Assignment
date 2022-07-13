package com.example.lib.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cta(
    @SerialName("bg_color")
    var bgColor: String? = null,
    @SerialName("text")
    var text: String? = null,
    @SerialName("text_color")
    var textColor: String? = null,
    @SerialName("url")
    var url: String? = null
)
