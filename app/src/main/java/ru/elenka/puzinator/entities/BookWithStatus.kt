package ru.elenka.puzinator.entities

data class BookWithStatus(
    val id: String,
    val title: String,
    val authors: List<String>,
    val imageUrl: String?,
    val status: BookmarkStatus
)