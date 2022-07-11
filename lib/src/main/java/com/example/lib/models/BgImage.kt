package com.example.lib.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BgImage(
    @SerialName("aspect_ratio")
    var aspectRatio: Double? = null,
    @SerialName("image_type")
    var imageType: String? = null,
    @SerialName("image_url")
    var imageUrl: String? = null
)