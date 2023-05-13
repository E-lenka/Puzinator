package ru.elenka.domain.repositories

import ru.elenka.domain.common.Result
import ru.elenka.domain.entities.Volume
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    suspend fun getRemoteBooks(author: String): Result<List<Volume>>

    suspend fun getBookmarks(): Flow<List<Volume>>

    suspend fun bookmark(book: Volume)

    suspend fun unbookmark(book: Volume)
}