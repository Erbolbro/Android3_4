package com.example.android3_4.data.models

import com.google.gson.annotations.SerializedName

data class InfoItem(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("content")
    val content: String = ""
)