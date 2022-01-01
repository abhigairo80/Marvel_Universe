package com.example.marveluniverse.data.data_source.dto.CharacterDTO

import com.example.marveluniverse.data.data_source.dto.CharacterDTO.ItemXX

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)