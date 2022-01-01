package com.example.marveluniverse.ui.CharactersList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveluniverse.domain.use_cases.CharactersUseCase
import com.example.marveluniverse.domain.use_cases.SearchCharacterCase
import com.example.marveluniverse.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase : CharactersUseCase,
    private val searchCharacterCase : SearchCharacterCase
) : ViewModel(){
    private val marvelValue = MutableStateFlow(MarvelListState())
    var _marvelValue : StateFlow<MarvelListState> = marvelValue

    fun getSearchedCharacters(search:String)=viewModelScope.launch(Dispatchers.IO){
        searchCharacterCase.invoke(search=search).collect {
            when(it){
                is State.Success ->{
                    marvelValue.value = MarvelListState(charactersList = it.data?: emptyList())
                    Log.d("toCharacter",_marvelValue.value.toString())
                }
                is State.Loading ->{
                    marvelValue.value = MarvelListState(isLoading = true)
                    Log.d("loading",it.data.toString())
                }
                is State.Error ->{
                    marvelValue.value = MarvelListState(error = it.message?:"An Unexpected Error")
                    Log.d("Error",it.data.toString())
                }
            }
        }
    }
    fun getAllCharactersData(offset:Int)=viewModelScope.launch(Dispatchers.IO){
        charactersUseCase(offset).collect {
            when(it){
                is State.Success ->{
                    marvelValue.value = MarvelListState(charactersList = it.data?: emptyList())
                    Log.d("toCharacter",_marvelValue.value.toString())
                }
                is State.Loading ->{
                    marvelValue.value = MarvelListState(isLoading = true)
                    Log.d("loading",it.data.toString())
                }
                is State.Error ->{
                    marvelValue.value = MarvelListState(error = it.message?:"An Unexpected Error")
                    Log.d("Error",it.data.toString())
                }
            }
        }
    }
}