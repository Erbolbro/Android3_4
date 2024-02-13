package com.example.android3_4.data.models

import com.google.gson.annotations.SerializedName

data class HarryPotterResponse(
    @SerializedName("characters")
    val characters: List<CharactersItem>?,
    @SerializedName("spells")
    val spells: List<SpellsItem>?,
    @SerializedName("info")
    val info: List<InfoItem>?
)