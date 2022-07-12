package com.example.lib.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardGroup(
    @SerialName("cards")
    var cards: MutableList<Card>? = mutableListOf(),
    @SerialName("design_type")
    var designType: String? = "",
    @SerialName("height")
    var height: Int? = 0,
    @SerialName("id")
    var id: Int? = 0,
    @SerialName("is_scrollable")
    var isScrollable: Boolean? = false,
    @SerialName("name")
    var name: String? = ""
)