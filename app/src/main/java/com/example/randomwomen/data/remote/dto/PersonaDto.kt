package com.example.randomwomen.data.remote.dto

data class PersonaDto (
    val name: Name,
    val nat: String,
    val picture: Picture
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class results(
    val results : List<PersonaDto>
)