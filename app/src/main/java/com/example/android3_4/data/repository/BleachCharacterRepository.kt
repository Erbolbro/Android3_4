package com.example.android3_4.data.repository

import com.example.android3_4.data.models.CharactersItem
import com.example.android3_4.data.models.HarryPotterResponse
import com.example.android3_4.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BleachCharacterRepository {

    private val apiServise = RetrofitClient.bleachCharacterApi

    fun getCharacter(
        onResponse: (character: List<CharactersItem>) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        apiServise.getCharacter().enqueue(object : Callback<HarryPotterResponse> {

            override fun onResponse(
                call: Call<HarryPotterResponse>,
                response: Response<HarryPotterResponse>
            ) {
                if (response.isSuccessful && response.body() != null)
                    onResponse(response.body()?.characters!!)
            }

            override fun onFailure(call: Call<HarryPotterResponse>, t: Throwable) {
                onFailure(t)

            }
        })
    }
}