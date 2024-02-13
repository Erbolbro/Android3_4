package com.example.android3_4.data.remote.api

import com.example.android3_4.data.models.HarryPotterResponse
import retrofit2.Call
import retrofit2.http.GET

private const val CHARACTER = "database.json"

interface BleachCharacterApi {

    @GET(CHARACTER)
    fun getCharacter(): Call<HarryPotterResponse>
}