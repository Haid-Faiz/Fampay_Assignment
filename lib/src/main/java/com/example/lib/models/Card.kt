package com.example.lib.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Card(
    @SerialName("bg_color")
    var bgColor: String? = "",
    @SerialName("bg_image")
    var bgImage: BgImage? = BgImage(),
    @SerialName("cta")
    var cta: List<Cta>? = listOf(),
    @SerialName("description")
    var description: String? = "",
    @SerialName("formatted_description")
    var formattedDescription: FormattedDescription? = FormattedDescription(),
    @SerialName("formatted_title")
    var formattedTitle: FormattedTitle? = FormattedTitle(),
    @SerialName("icon")
    var icon: Icon? = Icon(),
    @SerialName("name")
    var name: String? = "",
    @SerialName("title")
    var title: String? = "",
    @SerialName("url")
    var url: String? = ""
)