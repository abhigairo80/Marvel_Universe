package com.example.marveluniverse.data.data_source.dto.CharacterDTO

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)