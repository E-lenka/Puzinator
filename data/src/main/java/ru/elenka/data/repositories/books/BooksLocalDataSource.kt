package ru.elenka.data.repositories.books

import kotlinx.coroutines.flow.Flow
import ru.elenka.domain.entities.Volume

interface BooksLocalDataSource {
    suspend fun bookmark(book: Volume)
    suspend fun unbookmark(book: Volume)
    suspend fun getBookmarks(): Flow<List<Volume>>
}