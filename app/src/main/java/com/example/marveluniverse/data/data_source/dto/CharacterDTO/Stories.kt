package com.example.marveluniverse.data.data_source.dto.CharacterDTO

import com.example.marveluniverse.data.data_source.dto.CharacterDTO.ItemXXX

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)