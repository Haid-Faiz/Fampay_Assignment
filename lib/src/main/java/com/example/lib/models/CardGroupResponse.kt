package com.example.lib.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardGroupResponse(
    @SerialName("card_groups")
    var cardGroups: List<CardGroup>? = listOf()
)