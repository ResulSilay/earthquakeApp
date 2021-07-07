package com.example.quake.data.api.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class QuakeResponse (
    @SerializedName("results")
    val results: List<QuakeResults>? = null
)

data class QuakeResults(

    @SerializedName("timestamp") val timestamp: String? = null,
    @SerializedName("latitude") val latitude: Double? = null,
    @SerializedName("longitude") val longitude: Double? = null,
    @SerializedName("depth") val depth: Double? = null,
    @SerializedName("size") val size: Double? = null,
    @SerializedName("quality") val quality: Double? = null,
    @SerializedName("humanReadableLocation") val humanReadableLocation: String? = null
)