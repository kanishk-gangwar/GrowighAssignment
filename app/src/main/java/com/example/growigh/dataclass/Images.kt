package com.example.growigh.dataclass


data class Images(
    val id: String,
    val alt_description: String?,
    val urls: ImageUrls,
    val user: user,
    var likes : String?
)
