package com.example.marveluniverse.ui.Character

import com.example.marveluniverse.domain.model.CharacterModel

data class CharacterState(
    val isLoading : Boolean = false,
    val characterDetail : List<CharacterModel> = emptyList(),
    val error : String = ""
)