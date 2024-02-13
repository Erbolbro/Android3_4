package com.example.android3_4.ui.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_4.data.models.CharactersItem
import com.example.android3_4.data.models.HarryPotterResponse
import com.example.android3_4.data.repository.BleachCharacterRepository
import com.example.android3_4.utils.UiState

class CharacterViewModel : ViewModel() {

    private val characterRepository = BleachCharacterRepository()
    private val _characterLiveData = MutableLiveData<UiState<List<CharactersItem>>>()
    val characterLiveData: LiveData<UiState<List<CharactersItem>>> = _characterLiveData

    init {
        Log.e("narte", "model" )
        characterRepository.getCharacter(
            onResponse = {data->
                Log.e("TAG", "bleach,$data" )
                _characterLiveData.value = UiState(isLoading = false, success = data)
            },
            onFailure = {t->

                Log.e("narte", "model,$t" )
                _characterLiveData.value = UiState(isLoading = false,errorMessage = t.message?:"error")

            }
        )
    }
}