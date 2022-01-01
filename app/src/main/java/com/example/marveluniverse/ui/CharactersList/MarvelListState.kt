package com.example.marveluniverse.ui.CharactersList

import com.example.marveluniverse.domain.model.CharacterModel

data class MarvelListState(
    val isLoading : Boolean = false,
    val charactersList : List<CharacterModel> = emptyList(),
    val error : String = ""
)